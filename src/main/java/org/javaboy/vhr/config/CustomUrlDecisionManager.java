package org.javaboy.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @ClassName MyDecisionManager
 * @Description: 根据当前已经登录的用户是否在允许访问的角色列表中，这里的角色列表就是
 * MyFilter中获取的角色列表
 * @Author hl
 * @Date 2020/5/29
 * @Version V1.0
 **/
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o,
                       Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
       //MyFilter中getAttributes返回来的结果集，也就是角色列表
        for(ConfigAttribute configAttribute:collection){
            String needRole=configAttribute.getAttribute();//角色列表中的任意一个角色
            //被打了ROLB_LOGIN标记说明数据库中不包含当前url
            if("ROLB_LOGIN".equals(needRole)){
                //AnonymousAuthenticationToken是springsecurity提供的匿名类
                if(authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录，请登录！");
                }else{
                    return;
                }
            }

            //当前用户所具备的角色列表
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }

        }
        throw new AccessDeniedException("权限不足，请联系管理员！");

    }



    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
