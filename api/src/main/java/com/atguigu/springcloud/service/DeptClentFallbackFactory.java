package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClentFallbackFactory implements FallbackFactory<DeptClientService>
{

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get( Long id) {
                return new Dept().setDeptno(id).setDname("不存在这个数据").setDbSource("请求错误 来自FallBackFactory");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }
        };
    }
}
