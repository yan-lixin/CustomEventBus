package com.eventbus.annotation;

import com.eventbus.annotation.mode.SubscriberInfo;

/**
 * @author: lixin
 * Date: 2019-11-05
 * Description: 所有事件的订阅方法，生成索引接口
 */
public interface SubscriberInfoIndex {

    /**
     * 生成索引接口，通过订阅者对象获取所有订阅方法
     * @param subscriberClass 订阅者对象Class
     * @return 事件订阅方法封装类
     */
    SubscriberInfo getSubscriberInfo(Class<?> subscriberClass);
}
