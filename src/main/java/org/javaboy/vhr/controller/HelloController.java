package org.javaboy.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description: TODO
 * @Author hl
 * @Date 2020/5/21
 * @Version V1.0
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
      return "hello";
    }


    @GetMapping("/employee/basic/hello")
    public String hello1(){
        return "/employee/basic/hello";
    }



    @GetMapping("/employee/advanced/hello")
    public String hello2(){
        return "/employee/advanced/hello";
    }



}
