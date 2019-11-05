package com.eventbus;

import androidx.annotation.Nullable;

import com.eventbus.annotation.mode.SubscriberMethod;

/**
 * @author: lixin
 * Date: 2019-11-05
 * Description: 临时JavaBean对象
 */
public class Subscription {
    /**
     * 订阅者MainActivity.class
     */
    final Object subscriber;

    /**
     * 订阅的方法
     */
    final SubscriberMethod subscriberMethod;

    public Subscription(Object subscriber, SubscriberMethod subscriberMethod) {
        this.subscriber = subscriber;
        this.subscriberMethod = subscriberMethod;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Subscription) {
            Subscription otherSubscription = (Subscription) obj;
            return subscriberMethod.equals(otherSubscription.subscriberMethod);
        } else {
            return false;
        }
    }
}
