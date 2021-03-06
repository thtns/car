package com.thtns.car.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thtns.car.entity.BizMember;
import com.thtns.car.entity.BizTransactionRecord;
import com.thtns.car.enums.TransactionTypeEnum;
import com.thtns.car.mapper.BizTransactionRecordMapper;
import com.thtns.car.request.ListBizTransactionRecordRequest;
import com.thtns.car.response.LineTrResponse;
import com.thtns.car.response.ListBizTrResponse;
import com.thtns.car.response.PieTrResponse;
import com.thtns.car.response.bizTrExportResponse;
import com.thtns.car.service.IBizMemberService;
import com.thtns.car.service.IBizTransactionRecordService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 交易记录 服务实现类
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
@Service
public class BizTransactionRecordServiceImpl extends ServiceImpl<BizTransactionRecordMapper, BizTransactionRecord>
        implements IBizTransactionRecordService {

    private IBizMemberService bizMemberService;

    @Override
    public IPage<ListBizTrResponse> list(ListBizTransactionRecordRequest request) {

        Page<BizTransactionRecord> page = new Page<>(request.getPageNo(), request.getPageSize());
        LambdaQueryWrapper<BizTransactionRecord> query = Wrappers.lambdaQuery(BizTransactionRecord.class);
        query.eq(request.getMemberId() != null, BizTransactionRecord::getMemberId, request.getMemberId());
        query.eq(request.getCarId() != null, BizTransactionRecord::getCarId, request.getCarId());
        query.eq(request.getType() != null, BizTransactionRecord::getType, request.getType());
        query.eq(request.getCardType() != null, BizTransactionRecord::getCardType, request.getCardType());
        query.orderByDesc(BizTransactionRecord::getCreateTime, BizTransactionRecord::getStatus);

        Page<BizTransactionRecord> recordPage = page(page, query);

        List<Long> collect = recordPage.getRecords().stream().map(BizTransactionRecord::getMemberId).distinct()
                .collect(Collectors.toList());

        if (CollUtil.isNotEmpty(collect)) {
            List<BizMember> bizMembers = bizMemberService.listByIds(collect);

            Function<BizTransactionRecord, ListBizTrResponse> convert = t -> {
                ListBizTrResponse listBizTrResponse = new ListBizTrResponse();
                listBizTrResponse.setId(t.getId());
                listBizTrResponse.setMemberId(t.getMemberId());
                listBizTrResponse.setType(String.valueOf(t.getType()));
                listBizTrResponse.setPrice(String.valueOf(t.getPrice()));
                listBizTrResponse.setCardId(t.getCardId());
                listBizTrResponse.setCardType(t.getCardType());
                listBizTrResponse.setNumberPlate(t.getNumberPlate());
                listBizTrResponse.setStatus(t.getStatus());

                boolean present = Optional.ofNullable(t.getTradeTime()).isPresent();
                if (present) {
                    listBizTrResponse.setTradeTime(
                            t.getTradeTime().format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN)));
                }
                boolean create = Optional.ofNullable(t.getCreateTime()).isPresent();
                if (create) {
                    listBizTrResponse.setCreateTime(
                            t.getCreateTime().format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN)));
                }
                boolean update = Optional.ofNullable(t.getUpdateTime()).isPresent();
                if (update) {
                    listBizTrResponse.setUpdateTime(
                            t.getCreateTime().format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN)));
                }

                listBizTrResponse.setRemark(t.getRemark());
                return listBizTrResponse;
            };

            IPage<ListBizTrResponse> responseIPage = recordPage.convert(convert);

            responseIPage.getRecords().forEach(l -> bizMembers.forEach(b -> {
                if (l.getMemberId().equals(b.getId())) {
                    l.setName(b.getName());
                }

            }));

            return responseIPage;
        }

        return null;

    }

    @Override
    public List<LineTrResponse> line(ListBizTransactionRecordRequest request) {

        LambdaQueryWrapper<BizTransactionRecord> query = Wrappers.lambdaQuery(BizTransactionRecord.class);
        query.between(StringUtils.hasText(request.getBeginDate()) && StringUtils.hasText(request.getEndDate()),
                BizTransactionRecord::getCreateTime, request.getBeginDate(), request.getEndDate());
        List<BizTransactionRecord> list = list(query);

        Map<LocalDate, List<BizTransactionRecord>> collect = list.stream()
                .collect(Collectors.groupingBy(biztr -> biztr.getCreateTime().toLocalDate()));

        ArrayList<LineTrResponse> lineTrResponses = new ArrayList<>();
        collect.forEach((k, v) -> {

            LineTrResponse lineTrResponse = new LineTrResponse();

            Map<Integer, List<BizTransactionRecord>> typeCollect = v.stream()
                    .collect(Collectors.groupingBy(BizTransactionRecord::getType));

            //充值
            HashMap<LocalDate, BigDecimal> profit = new HashMap<>();
            //消费
            HashMap<LocalDate, BigDecimal> consumption = new HashMap<>();

            typeCollect.forEach((kt, vt) -> {

                if (1 == kt) {
                    BigDecimal reduce = vt.stream().map(BizTransactionRecord::getPrice)
                            .reduce(new BigDecimal("0.00"), BigDecimal::add);
                    consumption.put(k, reduce);
                }
                if (2 == kt) {
                    BigDecimal reduce = vt.stream().map(BizTransactionRecord::getPrice)
                            .reduce(new BigDecimal("0.00"), BigDecimal::add);
                    profit.put(k, reduce);
                }
            });

            lineTrResponse.setDate(k.toString());
            lineTrResponse.setProfit(profit.get(k) != null ? profit.get(k).toString() : "0.00");
            lineTrResponse.setConsumption(consumption.get(k) != null ? consumption.get(k).toString() : "0.00");
            lineTrResponses.add(lineTrResponse);
        });

        return lineTrResponses.stream().sorted(Comparator.comparing(LineTrResponse::getDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<PieTrResponse> pie(ListBizTransactionRecordRequest request) {
        LambdaQueryWrapper<BizTransactionRecord> query = Wrappers.lambdaQuery(BizTransactionRecord.class);
        query.between(StringUtils.hasText(request.getBeginDate()) && StringUtils.hasText(request.getEndDate()),
                BizTransactionRecord::getCreateTime, request.getBeginDate(), request.getEndDate());

        List<BizTransactionRecord> list = list(query);

        Map<Integer, List<BizTransactionRecord>> collect = list.stream()
                .collect(Collectors.groupingBy(BizTransactionRecord::getType));

        ArrayList<PieTrResponse> pieTrResponses = new ArrayList<>();
        collect.forEach((k, v) -> {

            PieTrResponse pie = new PieTrResponse();

            BigDecimal reduce = v.stream().map(BizTransactionRecord::getPrice)
                    .reduce(new BigDecimal("0.00"), BigDecimal::add);

            pie.setType(k.toString());
            pie.setProfit(reduce.toString());

            pieTrResponses.add(pie);
        });

        return pieTrResponses;
    }

    @Override
    @SneakyThrows
    public void export(ListBizTransactionRecordRequest request, HttpServletResponse response) {

        List<bizTrExportResponse> list = baseMapper.exportList(request);
        list.forEach(biztr -> biztr.setType(TransactionTypeEnum.parse(Integer.valueOf(biztr.getType())).toString()));
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("交易记录.xlsx", "UTF-8"));
        writer.merge(7, "交易记录");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(out);
    }

    @Autowired
    public void setBizMemberService(IBizMemberService bizMemberService) {
        this.bizMemberService = bizMemberService;
    }

}
