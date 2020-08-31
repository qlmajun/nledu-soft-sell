package com.newland.edu.ribbon.log.service;


import com.newland.edu.ribbon.log.model.Audit;

/***
 * 审计日志接口声明
 */
public interface IAuditService {
    /***
     * 保存审计日志
     * @param audit 审计日志封装对象
     */
    void save(Audit audit);
}
