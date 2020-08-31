package com.newland.edu.oauth.handler;

import cn.hutool.core.util.StrUtil;
import com.warrior.central.auth2.common.utils.AuthUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * OAuth退出登入处理
 *
 * @author majun
 * @date 2020/6/27
 */
@Slf4j
public class OauthLogoutHandler implements LogoutHandler {

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        Assert.notNull(tokenStore, "tokenStore must be set");

        //从请求参数中获取token值
        String token = httpServletRequest.getParameter("token");
        if (StrUtil.isEmpty(token)) {
            //获取requet(head/param)中的token
            token = AuthUtils.extractToken(httpServletRequest);
        }

        if (StrUtil.isNotEmpty(token)) {
            OAuth2AccessToken existingAccessToken = tokenStore.readAccessToken(token);
            OAuth2RefreshToken refreshToken;
            if (existingAccessToken != null) {
                if (existingAccessToken.getRefreshToken() != null) {
                    log.info("remove refreshToken!", existingAccessToken.getRefreshToken());
                    refreshToken = existingAccessToken.getRefreshToken();
                    tokenStore.removeRefreshToken(refreshToken);
                }
                log.info("remove existingAccessToken!", existingAccessToken);
                tokenStore.removeAccessToken(existingAccessToken);
            }
        }
    }
}
