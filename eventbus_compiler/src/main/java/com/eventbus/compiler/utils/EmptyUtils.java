package com.eventbus.compiler.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author: lixin
 * Date: 2019-11-05
 * Description:
 */
public final class EmptyUtils {

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(final Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
