package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Autowired
    private Car car;

    @RequestMapping("/hello")
    public String home()
    {
        return "Hello World!";
    }

    @RequestMapping("/car")
    public Car car()
    {
        return car;
    }
}
