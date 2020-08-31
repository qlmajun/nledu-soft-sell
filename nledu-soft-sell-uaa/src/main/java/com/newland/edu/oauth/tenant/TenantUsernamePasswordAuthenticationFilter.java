package com.newland.edu.oauth.tenant;

import com.warrior.central.auth2.common.token.TenantUsernamePasswordAuthenticationToken;
import com.warrior.central.common.context.TenantContextHolder;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 替换 UsernamePasswordAuthenticationFilter 增加租户id
 *
 * @author majun
 * @description
 * @date 2020/6/27
 */
public class TenantUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private boolean postOnly = true;

    public TenantUsernamePasswordAuthenticationFilter() {
        super();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String clientId = TenantContextHolder.getTenant();
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        username = username.trim();

        TenantUsernamePasswordAuthenticationToken authRequest = new TenantUsernamePasswordAuthenticationToken(username, password, clientId);
        setDetails(request, authRequest);
        return getAuthenticationManager().authenticate(authRequest);
    }
}
