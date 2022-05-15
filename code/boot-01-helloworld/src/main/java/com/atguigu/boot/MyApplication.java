package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 *
 * @SpringBootApplication: 这是一个 SpringBoot 应用
 */
// @SpringBootApplication(scanBasePackages = "com.atguigu")
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.atguigu.boot")
public class MyApplication
{
    public static void main(String[] args)
    {
        // 1. 返回 IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MyApplication.class, args);

        // 2. 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names)
        {
            System.out.println(name);
        }


    }
}
