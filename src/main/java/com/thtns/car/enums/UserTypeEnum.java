package com.thtns.car.enums;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * @author : liuyujun
 */
public enum UserTypeEnum implements IEnum<Integer> {

    vip(0, "会员"), ordinary(1, "散客");

    private final int code;
    private final String desc;

    UserTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    static final Map<Integer, UserTypeEnum> map = new HashMap<>();

    static {
        UserTypeEnum[] enums = UserTypeEnum.values();
        for (UserTypeEnum enumObj : enums) {
            map.put(enumObj.getValue(), enumObj);
        }
    }

    public static UserTypeEnum parse(Integer code) {
        return map.get(code);
    }

    @Override
    public Integer getValue() {
        return this.code;
    }

}
