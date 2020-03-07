package com.subs.service.activemq.config;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.Queue;


@Configuration
public class ConfigurationActiveMQ {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("email");
    }
}