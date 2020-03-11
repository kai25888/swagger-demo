package com.soldier.interfaceDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author soldier
 * @Date 2020/3/11 12:11
 * @Version 1.0
 * @Description: 自定义注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotIncludeSwagger {
}
