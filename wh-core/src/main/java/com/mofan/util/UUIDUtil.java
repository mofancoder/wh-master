package com.mofan.util;

import java.util.UUID;

/**
 * UUID 包装工具类
 */
public class UUIDUtil  {

    private UUIDUtil(){};

    /**
     * 生成小写的,不带-的UUID
     * 5ffeb997a74642b0a439a86d4fe9e3b7
     * @return
     */
    public static String  generateUUID(){
        return UUID.randomUUID().toString().toLowerCase().replaceAll("-","");
    }

}


