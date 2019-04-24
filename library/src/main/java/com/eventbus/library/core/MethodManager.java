package com.eventbus.library.core;

import com.eventbus.library.mode.ThreadMode;

import java.lang.reflect.Method;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019-04-24
 * Description: 保存符合要求的订阅方法的封装类
 */
public class MethodManager {

    /**
     * 参数类型
     */
    private Class<?> mType;

    /**
     * 线程模式
     */
    private ThreadMode mThreadMode;

    /**
     * 执行订阅方法
     */
    private Method mMethod;

    public MethodManager(Class<?> type, ThreadMode threadMode, Method method) {
        mType = type;
        mThreadMode = threadMode;
        mMethod = method;
    }

    public Class<?> getType() {
        return mType;
    }

    public void setType(Class<?> type) {
        mType = type;
    }

    public ThreadMode getThreadMode() {
        return mThreadMode;
    }

    public void setThreadMode(ThreadMode threadMode) {
        mThreadMode = threadMode;
    }

    public Method getMethod() {
        return mMethod;
    }

    public void setMethod(Method method) {
        mMethod = method;
    }
}
