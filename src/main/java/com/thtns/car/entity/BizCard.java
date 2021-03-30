package com.thtns.car.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员办理的业务卡
 * </p>
 *
 * @author liuyj
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BizCard对象", description = "会员办理的业务卡")
public class BizCard extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "会员ID")
    private Long memberId;

    @ApiModelProperty(value = "0=年卡 1=次卡 2=储值卡")
    private Integer type;

    @ApiModelProperty(value = "次数")
    private Integer num;

    @ApiModelProperty(value = "卡内余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "有效期")
    private LocalDate validDate;


}
