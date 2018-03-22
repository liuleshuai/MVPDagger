package com.example.common.tools;

/**
 * Created by LiuKuo at 2018/3/22
 */

import java.lang.reflect.ParameterizedType;

/**
 * 类反射初始化
 */
public class ClassUtil {
    /**
     * 反射生成实例
     *
     * @param o   上下文
     * @param i   泛型的位置
     * @param <T> 返回类型
     * @return
     */
    public static <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (ClassCastException e) {
        }
        return null;
    }

    /**
     * 由类名获取类
     *
     * @param className
     * @return
     */
    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
