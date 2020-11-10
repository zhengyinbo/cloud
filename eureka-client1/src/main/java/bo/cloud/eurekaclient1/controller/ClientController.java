package bo.cloud.eurekaclient1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/hello")
    public String get(){
        System.out.println("服务提供者1");
        int a = 10 / 0;
        return "Hello, springCloud 111";
    }

}
