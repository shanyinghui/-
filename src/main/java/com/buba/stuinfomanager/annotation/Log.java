package com.buba.stuinfomanager.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 表示需要在什么级别保存该注解信息
@Target(ElementType.METHOD) //表示该注解可以用于什么地方
@Documented //将注解包含在Javadoc中
public @interface Log {
}
