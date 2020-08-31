package com.newland.edu.ribbon.log.monitor;

import lombok.extern.slf4j.Slf4j;

/**
 * @author majun
 * @description 日志埋点工具类
 * @date 2020/6/15
 */
@Slf4j
public class PointUtil {
    /***
     * 日志消息格式
     */
    private static final String MSG_PATTERN = "{}|{}|{}";

    private PointUtil() {
        throw new IllegalStateException("Utility class");
    }

    /***
     * 格式为：{时间}|{来源}|{对象id}|{类型}|{对象属性(以&分割)}
     * 例子1：2020-06-15 23:37:23|business-center|1|user-login|ip=xxx.xxx.xx&userName=张三&userType=后台管理员
     * @param id
     * @param type
     * @param message
     */
    public static void info(String id, String type, String message) {
        log.info(MSG_PATTERN, id, type, message);
    }

    public static void debug(String id, String type, String message) {
        log.debug(MSG_PATTERN, id, type, message);
    }

}
