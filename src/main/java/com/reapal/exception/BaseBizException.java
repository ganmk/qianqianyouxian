package com.reapal.exception;

/**
 * 异常基础类型
 */
public interface BaseBizException {
    /**
     * 获取错误码
     *
     * @return
     */
    Integer getCode();

    /**
     * 获取错误描述
     *
     * @return
     */
    String getMessage();
}