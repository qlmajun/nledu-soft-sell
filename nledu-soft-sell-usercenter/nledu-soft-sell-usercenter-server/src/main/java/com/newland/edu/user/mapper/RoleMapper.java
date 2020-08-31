package com.newland.edu.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.common.model.SysRole;
import com.warrior.central.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper extends SuperMapper<SysRole> {

    List<SysRole> findAll();

    List<SysRole> findList(Page<SysRole> page, @Param("r") Map<String, Object> params);
}
