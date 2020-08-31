package com.newland.edu.ribbon.redis.constants;

/**
 * redis 工具常量
 *
 * @author 小马哥
 * @date 2020/06/19
 */
public class RedisToolsConstant {
    private RedisToolsConstant() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * single Redis
     */
    public final static int SINGLE = 1;

    /**
     * Redis cluster
     */
    public final static int CLUSTER = 2;
}
