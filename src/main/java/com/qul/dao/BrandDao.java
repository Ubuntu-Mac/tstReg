package com.qul.dao;

import com.qul.pojo.Brand;
import java.util.List;

public interface BrandDao {

    List<Brand> findAll();

    Brand findOne(long id);

    void save(Brand brand);

    void update(Brand brand);

    void del(long id);

    List<Brand> search(Brand brand);
}
