package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : liuyj
 */
@Data
public class RevokeRequest {

    @ApiModelProperty("交易记录id")
    private Long recordId;

    @ApiModelProperty("备注")
    private String remark;

}
