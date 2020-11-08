package com.oyoyoyo.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.oyoyoyo.entity.User;
import com.oyoyoyo.service.UserService;
import com.oyoyoyo.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Date:2020/11/5
 * Decription:<描述>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken token = (JwtToken) authenticationToken;
        String userId=jwtUtils.getClaimByToken((String) token.getPrincipal()).getSubject();
       User user= userService.getById(Long.valueOf(userId));
       if (user==null){
           throw new UnknownAccountException("账号不存在");
       }
       if (user.getStatus()==-1){
           throw new LockedAccountException("账号已锁定");
       }
        AccountProfile accountProfile = new AccountProfile();
        BeanUtil.copyProperties(user,accountProfile);

        return new  SimpleAuthenticationInfo(accountProfile,token.getCredentials(),getName());
    }
}
