package com.newland.edu.user.mapper;

import com.warrior.central.common.model.SysMenu;
import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.user.model.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleMenuMapper extends SuperMapper<SysRoleMenu> {

    /**
     * 根据角色Ids和类型获取菜单信息
     *
     * @param roleIds 角色Id集合
     * @param type    类型
     * @return
     */
    List<SysMenu> findMenusByRoleIds(@Param("roleIds") Set<Long> roleIds, @Param("type") Integer type);

    /**
     * 根据角色编码和类型获取菜单信息
     *
     * @param roleCodes 角色编码集合
     * @param type      类型
     * @return
     */
    List<SysMenu> findMenusByRoleCodes(@Param("roleCodes") Set<String> roleCodes, @Param("type") Integer type);

    /**
     * 删除角色菜单
     *
     * @param roleId 角色Id
     * @param menuId 菜单Id
     * @return
     */
    int delete(@Param("roleId") Long roleId, @Param("menuId") Long menuId);
}
