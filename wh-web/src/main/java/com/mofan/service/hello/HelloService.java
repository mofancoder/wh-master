package com.mofan.service.hello;

import com.mofan.bean.HelloBean;
import com.mofan.dao.hello.HelloDao;
import com.mofan.service.BaseService;

public interface HelloService extends BaseService {

    /**
     *
     * @param userID
     * @return
     */
    public HelloBean get(String userID);

}
