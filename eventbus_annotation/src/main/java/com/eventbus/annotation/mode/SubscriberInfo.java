package com.eventbus.annotation.mode;

/**
 * @author: lixin
 * Date: 2019-11-05
 * Description: 订阅信息
 */
public interface SubscriberInfo {

    /**
     * 订阅所需类
     * @return
     */
    Class<?> getSubscriberClass();

    /**
     * 获取订阅所属类中所有订阅事件的方法
     * @return
     */
    SubscriberMethod[] getSubscriberMethods();

}
