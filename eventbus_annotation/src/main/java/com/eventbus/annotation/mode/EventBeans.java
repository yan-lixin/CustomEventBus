package com.eventbus.annotation.mode;

/**
 * @author: lixin
 * Date: 2019-11-05
 * Description: 所有事件集合
 */
public class EventBeans implements SubscriberInfo {

    /**
     * 订阅者对象Class
     */
    private final Class mSubscriberClass;

    private final SubscriberMethod[] mMethodInfos;

    public EventBeans(Class subscriberClass, SubscriberMethod[] methodInfos) {
        mSubscriberClass = subscriberClass;
        mMethodInfos = methodInfos;
    }

    @Override
    public Class<?> getSubscriberClass() {
        return mSubscriberClass;
    }

    @Override
    public SubscriberMethod[] getSubscriberMethods() {
        return mMethodInfos;
    }
}
