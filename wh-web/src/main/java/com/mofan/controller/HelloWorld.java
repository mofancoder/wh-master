package com.mofan.controller;

import com.mofan.bean.HelloBean;
import com.mofan.service.hello.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mofan.util.RedisUtil;
import com.mofan.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/dream/test")
public class HelloWorld {

    @Value("${where.redis.ip}")
    public String redisIP;

	@Resource
	public HelloService helloService;

    @Resource
	public RedisUtil redisUtil;
	
	
	@RequestMapping(value="/hello",method= RequestMethod.GET)
	public String hello() throws InterruptedException {
        redisUtil.set("helloRedis","helloRedis value",1000L, TimeUnit.MILLISECONDS);
        System.out.println(redisUtil.get("helloRedis"));
        Thread.sleep(1000L);
        System.out.println(redisUtil.get("helloRedis"));
        HelloBean helloBean = helloService.get("1");
        System.out.println(helloBean.getPhone()+"@");
        return "hello world4";
	}
	
	public static void main(String[] args) {
		String randomStr = StringUtils.getRandomStr(6);
		System.out.println(randomStr);
	}
		
}
