package com.thtns.car.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;

/**
 * @author : liuyujun
 */
public enum TransactionTypeEnum implements IEnum<Integer> {

    consumption(1, "消费"), recharge(2, "充值");

    private final int code;
    private final String desc;

    TransactionTypeEnum(int value, String desc) {
        this.code = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.desc;
    }

}
