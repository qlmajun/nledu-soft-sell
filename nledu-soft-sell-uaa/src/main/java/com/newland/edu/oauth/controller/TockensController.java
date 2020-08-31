package com.newland.edu.oauth.controller;

import com.newland.edu.common.model.PageResult;
import com.newland.edu.oauth.model.TokenVo;
import com.newland.edu.oauth.service.ITokensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * token管理接口
 *
 * @author majun
 * @date 2020/7/31
 */
@RestController
@RequestMapping("/tokens")
public class TockensController {

    @Autowired
    private ITokensService tokensService;

    @GetMapping("")
    public PageResult<TokenVo> list(@RequestParam Map<String, Object> params, String tenantId) {
        return tokensService.listTokens(params, tenantId);
    }
}
