package bo.cloud.customer.config;

import com.netflix.hystrix.HystrixCommand;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义Hystrix请求的服务异常熔断处理
 */
public class MyHystrix extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    public MyHystrix(Setter setter, RestTemplate restTemplate){
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run(){
        //调用远程服务
        return restTemplate.getForEntity("http://eureka-client/hello", String.class).getBody();
    }

    @Override
    public String getFallback() {
        //实现服务熔断/降级逻辑
        System.out.println("MyHystrix");
        return "error";
    }

}
