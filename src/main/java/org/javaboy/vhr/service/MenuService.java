package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.MenuMapper;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuService
 * @Description: TODO
 * @Author hl
 * @Date 2020/5/28
 * @Version V1.0
 **/
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getMenuByHrId() {
        //这也是一种安全策略
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return menuMapper.getMenuByHrId(hr.getId());
    }

    //@Cacheable
    //启用缓存
    public List<Menu> getAllMenuWithRole(){
        return menuMapper.getAllMenuWithRole();
    }
}
