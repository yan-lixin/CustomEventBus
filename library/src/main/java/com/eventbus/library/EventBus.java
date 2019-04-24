package com.eventbus.library;

import com.eventbus.library.annotation.Subscribe;
import com.eventbus.library.core.MethodManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019-04-24
 * Description:
 */
public class EventBus {

    /**
     * volatile修饰的变量不允许线程内部的缓存和重排序，是一种轻量级的同步块。
     */
    private static volatile EventBus mInstance;

    /**
     * 用来保存带注解的方法(订阅方法)，key可能是Activity，也可能是Fragment。
     */
    private Map<Object, List<MethodManager>> mCacheMap;

    public EventBus() {
        mCacheMap = new HashMap<>();
    }

    public static EventBus getDefault() {
        if (mInstance == null) {
            synchronized (EventBus.class) {
                if (mInstance == null) {
                    mInstance = new EventBus();
                }
            }
        }
        return mInstance;
    }

    /**
     * 找到某个Activity所有带符合注解的方法
     *
     * @param getter 收到消息的方法
     */
    public void register(Object getter) {
        List<MethodManager> methodList = mCacheMap.get(getter);
        if (methodList == null) {
            methodList = findAnnotationMethod(getter);
            mCacheMap.put(getter, methodList);
        }
    }

    /**
     * @param setter 发送消息的方法
     */
    public void post(Object setter) {
        Set<Object> keySet = mCacheMap.keySet();
        // 获取某个Activity具体对象
        for (Object getter : keySet) {
            // 获取某个Activity中所有带注解的方法
            List<MethodManager> methodList = mCacheMap.get(getter);
            if (methodList != null) {
                // 循环执行每个订阅方法
                for (MethodManager method : methodList) {
                    // 判断发布者/订阅者 参数是否匹配
                    if (method.getType().isAssignableFrom(setter.getClass())) {
                        invoke(method, getter, setter);
                    }
                }
            }

        }
    }

    /**
     * 调用执行方法
     * @param method
     * @param getter 执行哪个Activity的方法
     * @param setter 方法的参数
     */
    private void invoke(MethodManager method, Object getter, Object setter) {
        Method execute = method.getMethod();
        try {
            execute.invoke(getter, setter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取某个Activity所有带注解的方法
     *
     * @param getter
     * @return
     */
    private List<MethodManager> findAnnotationMethod(Object getter) {
        List<MethodManager> methodList = new ArrayList<>();
        Class<?> clazz = getter.getClass();
        // 获取当前类以及父类的所有方法
        Method[] methods = clazz.getMethods();
        while (clazz != null) {
            String clazzName = clazz.getName();
            if (clazzName.startsWith("java.") || clazzName.startsWith("javax.") || clazzName.startsWith("android.")) {
                break;
            }
            for (Method method : methods) {
                Subscribe subscribe = method.getAnnotation(Subscribe.class);
                if (subscribe == null) {
                    continue;
                }
                // 方法的返回值必须是Void
                Type returnType = method.getGenericReturnType();
                if (!"void".equals(returnType.toString())) {
                    throw new RuntimeException(method.getName() + " 方法返回值必须是Void");
                }
                // 方法参数有且仅有一个
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new RuntimeException(method.getName() + " 方法参数有且仅有一个");
                }
                MethodManager manager = new MethodManager(parameterTypes[0], subscribe.threadModel(), method);
                methodList.add(manager);
            }

            // 不断去循环找出父类含有的订阅方法，直至为空
            clazz = clazz.getSuperclass();
        }
        return methodList;
    }
}
