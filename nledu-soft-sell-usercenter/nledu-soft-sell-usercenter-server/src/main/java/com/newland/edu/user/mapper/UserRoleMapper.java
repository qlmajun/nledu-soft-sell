package com.newland.edu.user.mapper;

import com.warrior.central.common.model.SysRole;
import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.user.model.SysRoleUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRoleMapper extends SuperMapper<SysRoleUser> {

    /**
     * 根据用户id获取角色
     *
     * @param userId
     * @return
     */
    List<SysRole> findRolesByUserId(@Param("userId") Long userId);

    /**
     * 根据用户ids 获取
     *
     * @param userIds
     * @return
     */
    @Select("<script>select r.*,ru.user_id from sys_role_user ru inner join sys_role r on r.id = ru.role_id where ru.user_id IN " +
            " <foreach item='item' index='index' collection='list' open='(' separator=',' close=')'> " +
            " #{item} " +
            " </foreach>" +
            "</script>")
    List<SysRole> findRolesByUserIds(List<Long> userIds);

    /**
     * 删除用户角色
     *
     * @param userId 用户Id
     * @param roleId 角色Id
     * @return
     */
    int deleteUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

}
