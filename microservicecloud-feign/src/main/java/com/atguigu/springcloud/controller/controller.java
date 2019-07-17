package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.Dept;
import com.atguigu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    @Autowired
    private DeptClientService service;

    @RequestMapping(value= "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return this.service.add(dept);
    }

    //只有请求路径和请求方法都匹配时才会调用该方法
    @RequestMapping(value= "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable Long id){
        return this.service.get(id);
    }

    @RequestMapping(value= "/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return this.service.findAll();
    }
}
