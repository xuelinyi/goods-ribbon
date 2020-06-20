package com.goods.controller;

import com.goods.entity.DemoVo;
import com.goods.entity.ResponseResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Autowired
    RestTemplate restTemplate;

    // 调用：localhost:6007/consumerServiceRibbon?token=1
    @GetMapping("/consumerDemoRibbon/{id}")
    @HystrixCommand(fallbackMethod="consumerDemoRibbonFallback")
    public ResponseResult<DemoVo> consumerDemoRibbon(@PathVariable(value = "id") Integer id){
        ResponseResult result = this.restTemplate.getForObject("http://goods-service/demo/"+id, ResponseResult.class);
        return result;
    }

    public ResponseResult<DemoVo> consumerDemoRibbonFallback(Integer id){
        ResponseResult responseResult = new ResponseResult();
        return responseResult.error("服务异常");
    }
}
