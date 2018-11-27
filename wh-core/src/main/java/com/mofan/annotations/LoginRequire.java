package com.mofan.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})//方法和接口、类、枚举、注解
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequire {

    /**
     * 是否需要登录
     * @return
     */
    boolean value() default true;

}
