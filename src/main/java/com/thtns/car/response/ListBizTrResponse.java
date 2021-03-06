package com.thtns.car.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : liuyj
 */
@Data
public class ListBizTrResponse {

    private Long id;
    private Long memberId;
    private String name;
    private String numberPlate;
    private String price;
    private String type;
    private String remark;
    private String createTime;
    private String phone;
    private String updateTime;
    private String tradeTime;
    private Integer cardType;
    private Long cardId;
    @ApiModelProperty("交易状态  1=正常 0=撤销")
    private Integer status;
}
