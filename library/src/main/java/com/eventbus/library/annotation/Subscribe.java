package com.eventbus.library.annotation;

import com.eventbus.library.mode.ThreadMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019-04-24
 * Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscribe {

    ThreadMode threadModel() default ThreadMode.POSTING;

}
