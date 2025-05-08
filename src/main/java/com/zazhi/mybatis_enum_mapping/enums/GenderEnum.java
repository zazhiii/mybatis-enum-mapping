package com.zazhi.mybatis_enum_mapping.enums;

/**
 * @author zazhi
 * @date 2025/5/7
 * @description: 性别枚举类
 */
public enum GenderEnum implements BaseEnum<Integer> {
    MALE(1),
    FEMALE(2),
    WALMART_SHOPPING_BAG(-1);

    private final Integer code;

    GenderEnum(int code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public static GenderEnum fromCode(Integer code) {
        for (GenderEnum gender : values()) {
            if (gender.getCode().equals(code)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Unknown gender code: " + code);
    }

    @Override
    public String toString() {
        return "GenderEnum{" +
                "code=" + code +
                '}';
    }
}
