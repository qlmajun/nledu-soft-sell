package com.newland.edu.api;

import com.newland.edu.common.constant.ServiceNameConstants;
import com.newland.edu.common.model.SysMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 菜单操作feign接口
 */
@FeignClient(name = ServiceNameConstants.USER_SERVICE, decode404 = true)
public interface IMenuServiceApi {
    /**
     * 角色菜单列表
     *
     * @param roleCodes
     */
    @GetMapping(value = "/menus/{roleCodes}")
    List<SysMenu> findByRoleCodes(@PathVariable("roleCodes") String roleCodes);
}
