package com.mofan.service.hello.impl;

import com.mofan.bean.HelloBean;
import com.mofan.dao.hello.HelloDao;
import com.mofan.service.hello.HelloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    public HelloDao helloDao;

    @Override
    public HelloBean get(String userID) {
        return helloDao.get(userID);
    }
}
