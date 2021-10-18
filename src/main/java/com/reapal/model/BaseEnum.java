package com.reapal.model;
import java.util.Objects;
/**
 * @author
 */
public interface BaseEnum<T> {

    T getCode();

    String getMessage();

    static <E extends Enum<E>> E valueOf(Class<E> enumClass, Object value) {
        E result = valueOfOrNull(enumClass, value);
        if (Objects.isNull(result)) {
            throw new IllegalStateException("无法识别的枚举值：" + value + "(" + enumClass.getName() + ")");
        }
        return result;
    }

    static <E extends Enum<E>> E valueOfOrNull(Class<E> enumClass, Object value) {
        if (!enumClass.isEnum()) {
            throw new IllegalArgumentException("该方法只支持枚举类型！");
        }
        if (!BaseEnum.class.isAssignableFrom(enumClass)) {
            throw new IllegalArgumentException("该方法的枚举类，必须实现BaseEnum接口！");
        }
        E[] es = enumClass.getEnumConstants();
        for (E e : es) {
            BaseEnum be = (BaseEnum) e;
            if (be.getCode().equals(value)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 判断code是否一致
     *
     * @param val
     *
     * @return
     */
    default boolean isEquals(T val) {
        if (val == null) {
            return false;
        }
        return this.getCode().equals(val);
    }

    /**
     * 判断code是否不一致
     *
     * @param val
     *
     * @return
     */
    default boolean isNotEquals(T val) {
        if (val == null) {
            return false;
        }
        return !this.getCode().equals(val);
    }
}