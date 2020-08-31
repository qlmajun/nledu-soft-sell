package com.newland.edu.ribbon.auth2.common.token;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 租户用户名密码认证token，增加租户id解决不同租户单点登录时角色没变化
 *
 * @author majun
 * @date 2020/6/27
 */
public class TenantUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = -5638287853803374687L;

    /**
     * 租户id
     */
    @Getter
    private final String clientId;

    public TenantUsernamePasswordAuthenticationToken(Object principal, Object credentials, String clientId) {
        super(principal, credentials);
        this.clientId = clientId;
    }

    public TenantUsernamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String clientId) {
        super(principal, credentials, authorities);
        this.clientId = clientId;
    }
}
