package com.newland.edu.common.constant;

/**
 * @author majun
 * @description 全局常量
 * @date 2020/8/31
 */
public interface CommonConstant {

    /**
     * 项目版本号(banner使用)
     */
    String PROJECT_VERSION = "1.0.0";

    /**
     * 租户id参数
     */
    String TENANT_ID_PARAM = "tenantId";

    /**
     * 日志链路追踪id信息头
     */
    String TRACE_ID_HEADER = "x-traceId-header";

    /**
     * 日志链路追踪id日志标志
     */
    String LOG_TRACE_ID = "traceId";

    String LOCK_KEY_PREFIX = "LOCK_KEY:";

    /**
     * token请求头名称
     */
    String TOKEN_HEADER = "Authorization";

    String BEARER_TYPE = "Bearer";

    /**
     * 超级管理员用户名
     */
    String ADMIN_USER_NAME = "admin";

    /**
     * 公共日期格式
     */
    String MONTH_FORMAT = "yyyy-MM";
    String DATE_FORMAT = "yyyy-MM-dd";
    String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    String SIMPLE_MONTH_FORMAT = "yyyyMM";
    String SIMPLE_DATE_FORMAT = "yyyyMMdd";
    String SIMPLE_DATETIME_FORMAT = "yyyyMMddHHmmss";

    String DEF_USER_PASSWORD = "123456";

    /**
     * 目录
     */
    Integer CATALOG = -1;

    /**
     * 菜单
     */
    Integer MENU = 1;

    /**
     * 权限
     */
    Integer PERMISSION = 2;

    /**
     * 负载均衡策略-版本号 信息头
     */
    String X_M_G_VERSION = "x-m-g-version";

    /**
     * 注册中心元数据 版本号
     */
    String METADATA_VERSION = "version";
}
