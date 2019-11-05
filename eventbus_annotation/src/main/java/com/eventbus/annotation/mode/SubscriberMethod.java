package com.eventbus.annotation.mode;

import java.lang.reflect.Method;

/**
 * @author: lixin
 * Date: 2019-11-05
 * Description: 事件订阅方法封装类
 */
public class SubscriberMethod {

    /**
     * 订阅方法名
     */
    private String mMethodName;

    /**
     * 订阅方法，用于invoke
     */
    private Method mMethod;

    /**
     * 线程模式
     */
    private ThreadMode mThreadMode;

    /**
     * 事件对象Class
     */
    private Class<?> mEventType;

    /**
     * 订阅事件优先级
     */
    private int mPriority;

    /**
     * 是否粘性事件
     */
    private boolean mSticky;

    public SubscriberMethod(Class subscriberClass, String methodName, Class<?> eventType, ThreadMode threadMode, int priority, boolean sticky) {
        mMethodName = methodName;
        mThreadMode = threadMode;
        mEventType = eventType;
        mPriority = priority;
        mSticky = sticky;
        try {
            mMethod = subscriberClass.getDeclaredMethod(methodName, eventType);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public String getMethodName() {
        return mMethodName;
    }

    public Method getMethod() {
        return mMethod;
    }

    public ThreadMode getThreadMode() {
        return mThreadMode;
    }

    public Class<?> getEventType() {
        return mEventType;
    }

    public int getPriority() {
        return mPriority;
    }

    public boolean isSticky() {
        return mSticky;
    }
}
