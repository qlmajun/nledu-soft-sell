package com.newland.edu.oauth.service;

import com.warrior.central.common.model.PageResult;
import com.warrior.central.oauth.model.TokenVo;

import java.util.Map;

public interface ITokensService {
    /**
     * 查询token列表
     *
     * @param params   请求参数
     * @param clientId 应用id
     */
    PageResult<TokenVo> listTokens(Map<String, Object> params, String clientId);
}
