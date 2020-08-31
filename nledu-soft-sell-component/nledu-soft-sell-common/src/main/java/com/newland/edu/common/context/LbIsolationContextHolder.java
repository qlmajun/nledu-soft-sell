package com.newland.edu.common.context;


import com.alibaba.ttl.TransmittableThreadLocal;

/***
 * 负载均衡策略Holder
 * @author majun
 * @date 2020/8/31
 */
public class LbIsolationContextHolder {
    private static final ThreadLocal<String> VERSION_CONTEXT = new TransmittableThreadLocal<>();

    public static void setVersion(String version) {
        VERSION_CONTEXT.set(version);
    }

    public static String getVersion() {
        return VERSION_CONTEXT.get();
    }

    public static void clear() {
        VERSION_CONTEXT.remove();
    }
}
