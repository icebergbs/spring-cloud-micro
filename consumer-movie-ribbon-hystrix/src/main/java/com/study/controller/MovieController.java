package com.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
  private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private LoadBalancerClient loadBalancerClient;
  //Hystrix容错
  @HystrixCommand(fallbackMethod = "findByIdFallback")
  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    return this.restTemplate.getForObject("http://provider-user/" + id, User.class);
  }

  public User findByIdFallback(Long id){
    User user = new User();
    user.setId(-1L);
    user.setName("默认用户");
    return user;
  }


  @GetMapping("/log")
  public String logUserInstance() {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider-user");
    //打印当前选择的是哪个节点
    logger.info("{}:{}:{}", serviceInstance.getServiceId(),
            serviceInstance.getHost(), serviceInstance.getPort());
    return "success";
  }
}
