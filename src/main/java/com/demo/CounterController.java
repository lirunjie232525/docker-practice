package com.demo;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.data.redis.core.StringRedisTemplate;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RestController;

  @RestController
  public class CounterController {

      @Autowired
      private StringRedisTemplate redis;

      @GetMapping("/count")
      public String count() {
          Long n = redis.opsForValue().increment("visitor-count");
          return "你是第 " + n + " 次访问本页面";
      }
  }