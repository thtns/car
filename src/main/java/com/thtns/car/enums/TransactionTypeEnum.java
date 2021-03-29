package com.thtns.car.enums;

import java.util.HashMap;
import java.util.Map;

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

    TransactionTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    static final Map<Integer, TransactionTypeEnum> map = new HashMap<>();

    static {
        TransactionTypeEnum[] enums = TransactionTypeEnum.values();
        for (TransactionTypeEnum enumObj : enums) {
            map.put(enumObj.getValue(), enumObj);
        }
    }

    public static TransactionTypeEnum parse(Integer code) {
        return map.get(code);
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
