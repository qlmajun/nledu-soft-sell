package com.newland.edu.oauth.service.impl;

import com.warrior.central.common.constant.SecurityConstants;
import com.warrior.central.common.model.Result;
import com.warrior.central.oauth.exception.ValidateCodeException;
import com.warrior.central.oauth.service.IValidateCodeService;
import com.warrior.central.redis.template.RedisRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author majun
 * @description
 * @date 2020/6/27
 */
@Service
public class ValidateCodeService implements IValidateCodeService {

    @Autowired
    private RedisRepository redisRepository;

    @Override
    public void saveImageCode(String deviceId, String imageCode) {
        redisRepository.setExpire(buildKey(deviceId), imageCode, SecurityConstants.DEFAULT_IMAGE_EXPIRE);
    }

    @Override
    public Result sendSmsCode(String mobile) {
        return null;
    }

    @Override
    public String getCode(String deviceId) {
        return (String) redisRepository.get(buildKey(deviceId));
    }

    @Override
    public void remove(String deviceId) {
        redisRepository.del(buildKey(deviceId));
    }

    @Override
    public void validate(String deviceId, String validCode) {
        if (StringUtils.isBlank(deviceId)) {
            throw new ValidateCodeException("请在请求参数中携带deviceId参数");
        }
        String code = this.getCode(deviceId);
        if (StringUtils.isBlank(validCode)) {
            throw new ValidateCodeException("请填写验证码");
        }

        if (code == null) {
            throw new ValidateCodeException("验证码不存在或已过期");
        }

        if (!StringUtils.equals(code, validCode.toLowerCase())) {
            throw new ValidateCodeException("验证码不正确");
        }

        this.remove(deviceId);
    }

    private String buildKey(String deviceId) {
        return SecurityConstants.DEFAULT_CODE_KEY + ":" + deviceId;
    }
}
