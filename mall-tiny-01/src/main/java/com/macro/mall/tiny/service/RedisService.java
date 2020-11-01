package com.macro.mall.tiny.service;

/**
 * Author:zhanggang
 * Date:2020/11/1
 * Decription:<redis操作service对象和数组都以json的形式存储>
 */
public interface RedisService {
    /**
     * 存储数据
     *
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置超期时间
     *
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     *
     * @param key
     */
    void remove(String key);

    /**
     * 自增炒作
     *
     * @param key
     * @param delta 自增步长
     * @return
     */
    Long increment(String key, long delta);
}
