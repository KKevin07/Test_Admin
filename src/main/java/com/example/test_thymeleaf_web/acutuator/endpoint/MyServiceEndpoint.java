package com.example.test_thymeleaf_web.acutuator.endpoint;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myservice")
public class MyServiceEndpoint {

    @ReadOperation  //端点的读操作   http://localhost:8080/actuator/myservice
    public Map getDockerInfo(){
        return Collections.singletonMap("dockerInfo","docker started....");
    }


    public void stopDocker(){
        System.out.println("docker stopped.......");
    }

}
