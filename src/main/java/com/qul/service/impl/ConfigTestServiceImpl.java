package com.qul.service.impl;

import com.qul.dao.ConfigTsetDao;
import com.qul.pojo.ConfigTest;
import com.qul.service.ConfigTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigTestServiceImpl implements ConfigTestService {

    @Autowired
    private ConfigTsetDao configTsetDao;

    @Override
    public ConfigTest findTset() {
        return configTsetDao.findTset();
    }
}
