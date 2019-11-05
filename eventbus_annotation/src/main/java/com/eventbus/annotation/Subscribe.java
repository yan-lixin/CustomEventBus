package com.eventbus.annotation;

import com.eventbus.annotation.mode.ThreadMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: lixin
 * Date: 2019-11-05
 * Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface Subscribe {
    /**
     * 线程模式
     */
    ThreadMode threadMode() default ThreadMode.POSTING;

    /**
     * 是否使用粘性事件
     */
    boolean sticky() default false;

    /**
     * 事件订阅优先级，在同一线程中，数值越大优先级越高
     */
    int priority() default 0;
}
