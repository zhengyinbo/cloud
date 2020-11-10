package bo.cloud.customer.controller;


import bo.cloud.customer.config.BeanConfig;
import bo.cloud.customer.config.MyHystrix;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private BeanConfig beanConfig;

    @Autowired
    public void helloController(BeanConfig beanConfig){
        this.beanConfig = beanConfig;
    }

    @GetMapping("/hello")
    public String hello(){
        return beanConfig.restTemplate().
                getForEntity("http://eureka-client/hello", String.class).getBody();
    }

    /**
     * ignoreExceptions 忽略异常熔断方法
     * @return
     */
    @HystrixCommand(fallbackMethod="error")
    @GetMapping("/hello1")
    public String hello1(){
        return beanConfig.restTemplate().
                getForEntity("http://eureka-client/hello", String.class).getBody();
    }

    @GetMapping("/hello2")
    public String hello2(){
        MyHystrix myHystrix = new MyHystrix(
                com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),
                        beanConfig.restTemplate());
        return myHystrix.execute();
    }

    public String error(){
        return "error";
    }

}
