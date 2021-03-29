package com.thtns.car.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : liuyj
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ListBizTransactionRecordRequest extends PageRequest {

    private Long memberId;

}
