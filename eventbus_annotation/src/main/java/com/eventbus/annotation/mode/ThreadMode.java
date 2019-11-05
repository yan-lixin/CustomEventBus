package com.eventbus.annotation.mode;

/**
 * @author: lixin
 * Date: 2019-11-05
 * Description: 线程模式
 */
public enum  ThreadMode {

    // 订阅、发布在同一线程
    POSTING,
    // 主线程中被调用
    MAIN,
    // 用于网络访问等耗时操作，事件总线已完成的异步订阅通知线程，并使用线程池有效地重用
    ASYNC
}
