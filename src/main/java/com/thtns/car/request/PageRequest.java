package com.thtns.car.request;

import lombok.Data;

/**
 * @author : liuyj
 */

@Data
public class PageRequest {

    private int pageNo = 1;

    private int pageSize = 10;

}
