package com.reapal.model;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    public long PageCount;
    public long TotalCount;
    public long PageNo;
    public long PageSize;
    public List<T> Results;
}
