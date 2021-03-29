package com.thtns.car.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : liuyujun
 */
public enum CardTypeEnum implements IEnum<Integer> {

    year(0, "年卡"), num(1, "次卡"), stored(2, "储蓄卡");

    private final int code;
    private final String desc;

    static final Map<Integer, CardTypeEnum> map = new HashMap<>();

    static {
        CardTypeEnum[] enums = CardTypeEnum.values();
        for (CardTypeEnum enumObj : enums) {
            map.put(enumObj.getValue(), enumObj);
        }
    }

    CardTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CardTypeEnum parse(Integer code) {
        return map.get(code);
    }

    @Override
    public Integer getValue() {
        return this.code;
    }

}
