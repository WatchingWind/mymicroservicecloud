package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor//设置全参构造
@NoArgsConstructor//设置空参构造
@Data//为每个属性设置get set
@Accessors(chain = true) //设置链式调用
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String dbSource;



}
