package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : liuyj
 */
@Data
public class AddBizMemberRequest {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "车牌号")
    private String numberPlate;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "车型名称")
    private String carName;

    @ApiModelProperty("业务卡种类")
    private AddBizCardRequest cardRequest;

}
