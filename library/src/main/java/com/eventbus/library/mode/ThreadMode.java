package com.eventbus.library.mode;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019-04-24
 * Description:
 */
public enum ThreadMode {
    //事件处理和事件的发送在相同的线程，所以处理时间不应太长，不然影响事件的发送线程，而这个线程可能是UI线程
    POSTING,
    //事件的处理会在UI线程中执行，事件处理不应太长时间
    MAIN,
    //后台线程，处理如保存到数据库等操作
    BACKGROUND,
    //异步执行，另起线程操作。事件处理会在单独的线程中执行，主要是用于后台线程中执行耗时操作。
    ASYNC;
}
