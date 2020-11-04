package com.oyoyoyo.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Date:2020/11/5
 * Decription:<获取 JWT Token>
 *
 * @Author:oyoyoyoyoyoyo
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
