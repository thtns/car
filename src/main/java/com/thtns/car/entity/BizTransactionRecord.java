package com.thtns.car.entity;

import com.thtns.car.enums.TransactionTypeEnum;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 交易记录
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BizTransactionRecord对象", description = "交易记录")
public class BizTransactionRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "交易金额")
    private BigDecimal price;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "充值类型 1=消费 2=充值")
    private Integer type;

    @ApiModelProperty(value = "卡ID")
    private Long cardId;

    @ApiModelProperty(value = "卡类型")
    private Integer cardType;

    @ApiModelProperty(value = "交易时间")
    private LocalDateTime tradeTime;

}
