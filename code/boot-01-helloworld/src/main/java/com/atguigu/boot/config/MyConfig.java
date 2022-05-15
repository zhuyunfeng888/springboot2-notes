package com.atguigu.boot.config;

import ch.qos.logback.core.boolex.Matcher;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1、配置类里面使用 @Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods: 代理 bean的方法
 * Full(proxyBeanMethods = true): 保证每个 @Bean方法被调用多少次返回的组件都是单实例的
 * Lite(proxyBeanMethods = false): 每个@Bean方法被调用多少次返回的组件都是新创建的
 * <p>
 * 组件依赖必须使用 Full模式，其他默认都是 Lite模式
 * <p>
 * 4、@Import({User.class, Matcher.class})
 * 给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 */
@Import({User.class, Matcher.class})
// @ConditionalOnBean(name = "tom22")
@ConditionalOnMissingBean(name = "tom")
@Configuration(proxyBeanMethods = false) /* 告诉 SpringBoot这是一个配置类 === 配置文件 */
public class MyConfig
{

    /**
     * Full: 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     *
     * @return
     */

    @Bean /* 给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型，返回的值，就是组件在容器中的实例 */
    public User user01()
    {
        User user = new User("zhangsan", 18);
        user.setPet(tomcatPet());
        return user;
    }

    @Bean("tom22")
    public Pet tomcatPet()
    {
        return new Pet("tomcat");
    }
}
