package com.qul.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qul.dao.BrandDao;
import com.qul.pageresult.PageResult;
import com.qul.pojo.Brand;
import com.qul.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public PageResult findAll() {
        int page=1;
        int size=10;
        PageHelper.startPage(page,size);
        Page<Brand> list = (Page<Brand>) brandDao.findAll();
        return new PageResult(list.getTotal(),list.getResult(),list.getPageNum());
    }

    @Override
    public Brand findOne(long id) {
        return brandDao.findOne(id);
    }

    @Override
    public void save(Brand brand) {
        brandDao.save(brand);
    }

    @Override
    public void update(Brand brand) {
        brandDao.update(brand);
    }

    @Override
    public void del(long[] ids) {
        for (long id : ids) {
            brandDao.del(id);
        }
    }

    @Override
    public PageResult search(Brand brand, String str_page, String str_size) {
        int page;
        if (Integer.parseInt(str_page)==0){
            page=1;
        } else {
            page=Integer.parseInt(str_page);
        }
        int size;
        if (Integer.parseInt(str_size)==0){
            size=10;
        }else {
            size=Integer.parseInt(str_size);
        }
        PageHelper.startPage(page,size);
        Page<Brand> list = (Page<Brand>) brandDao.search(brand);
        return new PageResult(list.getTotal(),list.getResult(),list.getPageNum());
    }
}
