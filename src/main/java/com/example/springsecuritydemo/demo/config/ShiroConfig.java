package com.example.springsecuritydemo.demo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//shiro配置类
@Configuration
public class ShiroConfig {
    //和用户相关
    @Bean
    public Realm realm(){
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("sang=123,user\n admin=123,admin");
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return realm;
    }
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chainDefinition =
                new DefaultShiroFilterChainDefinition();
        //login和doLogin可以匿名访问，logout注销登录请求，其余请求需要授权才能访问
        chainDefinition.addPathDefinition("/login","anon");
        chainDefinition.addPathDefinition("/doLogin","anon");
        chainDefinition.addPathDefinition("/logout","logout");
        chainDefinition.addPathDefinition("/**","authc");
        return chainDefinition;
    }
    //在thymeleaf中支持shiro
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
