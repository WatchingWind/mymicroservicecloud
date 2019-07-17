package com.atgui.controller;

import com.atguigu.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DepartController_Consumer {
 //   private  static final String REST_URL_PREFIX ="http://localhost:8001";
    private  static final String REST_URL_PREFIX = "http://STUDY-SPRINGCLOUD-DEPT";
    @Autowired
    private RestTemplate restTemplate;

    //RequestBody是转换json字符串和对象的，如果这里用RquestBody声明后，却通过get传输数据，是不行的会返回400错误，请求异常
    //这里之所以可以调用provider，如下，是因为 RestTemplate是通过post请求传送到数据
    /*@RequestMapping(value= "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return service.add(dept);
    }*/
    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return  restTemplate.postForObject(REST_URL_PREFIX + "/dept/add/",dept,Boolean.class);
    }

    //RequestBody是转换json字符串和
    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return  restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }


    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return  restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
    }

    @RequestMapping(value = "consumer/dept/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery",Object.class);
    }
}
