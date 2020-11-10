package bo.cloud.eurekaclient2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/hello")
    public String get(){
        System.out.println("服务提供者2");
        return "Hello, springCloud 222";
    }

}
