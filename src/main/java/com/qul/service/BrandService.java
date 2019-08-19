package com.qul.service;

import com.qul.pageresult.PageResult;
import com.qul.pojo.Brand;

import java.util.List;

public interface BrandService {
    PageResult findAll();
    Brand findOne(long id);

    void save(Brand brand);

    void update(Brand brand);

    void del(long[] ids);

    PageResult search(Brand brand, String page, String size);
}
