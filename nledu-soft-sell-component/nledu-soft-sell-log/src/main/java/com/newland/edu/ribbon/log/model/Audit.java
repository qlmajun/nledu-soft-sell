package com.newland.edu.ribbon.log.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author majun
 * @description 审计日志封装对象
 * @date 2020/8/31
 */
@Getter
@Setter
public class Audit {

    /***
     * 操作时间
     */
    private LocalDateTime timestamp;

    /***
     * 应用名称
     */
    private String applicationName;

    /****
     * 类名
     */
    private String className;

    /***
     * 方法名
     */
    private String methodName;

    /***
     * 用户Id
     */
    private String userId;

    /***
     * 用户名称
     */
    private String userName;

    /***
     * 租户Id
     */
    private String clientId;

    /***
     * 操作信息
     */
    private String operation;
}
