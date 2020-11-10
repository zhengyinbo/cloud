package com.bo.feign1.service;

import com.bo.feign1.fallback.MyFallback;
import com.bo.feign1.fallback.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eureka-client", fallbackFactory = MyFallbackFactory.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
