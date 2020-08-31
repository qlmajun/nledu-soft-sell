package com.newland.edu.oauth.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.warrior.central.db.mapper.SuperMapper;
import com.warrior.central.oauth.model.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author majun
 * @date 2020/6/27
 */
@Mapper
public interface ClientMapper extends SuperMapper<Client> {

    List<Client> findList(Page<Client> page, @Param("params") Map<String, Object> params);
}
