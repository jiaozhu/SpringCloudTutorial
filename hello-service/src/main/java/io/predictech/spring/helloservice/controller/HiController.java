package io.predictech.spring.helloservice.controller;

import io.predictech.spring.helloservice.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Weijie Zhao
 * @email tttx(at)me.com
 * @date 23/12/2017
 * @description
 */
@RestController
public class HiController {

    private Logger logger = LoggerFactory.getLogger(HiController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("/hi, host: {}, service_id: {}", instance.getHost(), instance.getServiceId());
        return "Hello World";
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public User hello(@RequestHeader String name,@RequestHeader Integer age){
        return new User(name,age);
    }

    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "Hello " + user.getName()+", " + user.getAge();
    }
}
