package com.atguigu.spsringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Dept_Consumer_DashBoard_APP {
    public static void main(String[] args) {
        SpringApplication.run(Dept_Consumer_DashBoard_APP.class,args);
    }
}
