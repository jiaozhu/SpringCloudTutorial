package io.predictech.spring.feignconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Weijie Zhao
 * @email tttx(at)me.com
 * @date 2018/4/2
 * @description
 */
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hi")
    String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
}
