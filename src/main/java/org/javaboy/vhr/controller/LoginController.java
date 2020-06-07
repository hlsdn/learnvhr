package org.javaboy.vhr.controller;

import org.javaboy.vhr.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description: TODO
 * @Author hl
 * @Date 2020/5/22
 * @Version V1.0
 **/
@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return  RespBean.error("尚未登录，请重新的登录");
    }
}
