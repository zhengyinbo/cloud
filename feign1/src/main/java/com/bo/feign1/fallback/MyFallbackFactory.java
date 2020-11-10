package com.bo.feign1.fallback;

import com.bo.feign1.service.HelloService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFallbackFactory implements FallbackFactory<HelloService> {

    @Override
    public HelloService create(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return new HelloService() {
            @Override
            public String hello() {
                return throwable.getMessage();
            }
        };
    }
}
