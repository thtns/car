package com.thtns.car.response;

import lombok.Data;

/**
 * @author : liuyj
 */
@Data
public class bizTrExportResponse {

    private Long id;
    private String name;
    private String numberPlate;
    private String price;
    private String type;
    private String remark;
    private String createTime;

}
