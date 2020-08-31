package com.newland.edu.oauth.service.impl;

import com.warrior.central.common.model.LoginAppUser;
import com.warrior.central.oauth.service.CustomerUserDetailsService;
import com.warrior.central.server.api.IUserServiceApi;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author majun
 * @date 2020/6/27
 */
@Service
public class UserDetailServiceImpl implements CustomerUserDetailsService, SocialUserDetailsService {

    @Resource
    private IUserServiceApi userServiceApi;

    @Override
    public UserDetails loadUserByMobile(String mobile) {
        LoginAppUser loginAppUser = userServiceApi.findByMobile(mobile);
        return checkUser(loginAppUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginAppUser loginAppUser = userServiceApi.findByUsername(username);
        if (loginAppUser == null) {
            throw new InternalAuthenticationServiceException("用户名或密码错误");
        }
        return checkUser(loginAppUser);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String openId) throws UsernameNotFoundException {
        LoginAppUser loginAppUser = userServiceApi.findByOpenId(openId);
        return checkUser(loginAppUser);
    }

    private LoginAppUser checkUser(LoginAppUser loginAppUser) {
        if (loginAppUser != null && !loginAppUser.isEnabled()) {
            throw new DisabledException("用户已作废");
        }
        return loginAppUser;
    }
}
