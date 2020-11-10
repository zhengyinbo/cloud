package com.bo.feign1.controller;

import com.bo.feign1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/web/hello")
    public String hello(){
        return helloService.hello();
    }

}
