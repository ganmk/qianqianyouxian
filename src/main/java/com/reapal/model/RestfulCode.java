package com.reapal.model;

public interface RestfulCode extends BaseEnum<Integer> {

    /**
     * 成功
     */
    RestfulCode SUCCESS = new RestfulCode() {
        @Override
        public Integer getCode() {
            return 0;
        }

        @Override
        public String getMessage() {
            return "SUCCESS";
        }
    };
}