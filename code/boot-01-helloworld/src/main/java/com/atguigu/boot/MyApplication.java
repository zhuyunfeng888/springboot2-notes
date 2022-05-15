package com.atguigu.boot;

import ch.qos.logback.core.ContextBase;
import ch.qos.logback.core.boolex.Matcher;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
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

        // 3. 从容器中获取组件
        // Pet tom01 = run.getBean("tom22", Pet.class);
        //
        // Pet tom02 = run.getBean("tom22", Pet.class);
        //
        // System.out.println("组件: " + (tom01 == tom02));

        // 4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$51f1e1ca@1654a892
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        // 如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        // 保持组件单实例
        User user = bean.user01();
        User user2 = bean.user01();
        System.out.println(user == user2);

        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom22", Pet.class);
        System.out.println("用户的宠物: " + (user01.getPet() == tom));

        // 5、获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("===============================");
        for (String s : beanNamesForType)
        {
            System.out.println(s);
        }

        Matcher matcher = run.getBean(Matcher.class);
        System.out.println(matcher);
    }
}
