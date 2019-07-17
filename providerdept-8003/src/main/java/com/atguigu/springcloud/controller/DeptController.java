package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController
{
    @Autowired
    private DeptServiceImpl service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value= "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
       return service.add(dept);
    }

    //只有请求路径和请求方法都匹配时才会调用该方法
    @RequestMapping(value= "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable Long id){
        return service.get(id);
    }

    @RequestMapping(value= "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return service.findAll();
    }


    @RequestMapping(value="/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("STUDY-SPRINGCLOUD-DEPT");//这里对应的是应用名
        for (ServiceInstance element: serviceInstanceList
             ) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }
}
