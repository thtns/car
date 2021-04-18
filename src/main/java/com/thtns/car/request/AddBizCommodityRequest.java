package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liuyj
 * node 添加办卡赠送的服务
 */

@Data
public class AddBizCommodityRequest {

    @ApiModelProperty(value = "商品Id")
    private Long id;


    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品数量")
    private Integer num;

}
