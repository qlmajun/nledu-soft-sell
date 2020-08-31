package com.newland.edu.oauth.service;


import com.newland.edu.common.model.PageResult;
import com.newland.edu.common.model.Result;
import com.newland.edu.common.service.ISuperService;
import com.newland.edu.oauth.model.Client;

import java.util.Map;

public interface IClientService extends ISuperService<Client> {

    Result saveClient(Client clientDto) throws Exception;

    /**
     * 查询应用列表
     *
     * @param params
     * @param isPage 是否分页
     */
    PageResult<Client> listClient(Map<String, Object> params, boolean isPage);

    void delClient(long id);
}
