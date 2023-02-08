package com.bilgeadam.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private String exchangeAuth = "exchange-auth";
    private String keyAuth = "key-auth";
    private String queueAuth = "queue-auth-create-employee";

    @Bean
    DirectExchange exchangeAuth(){return new DirectExchange(exchangeAuth);}

    @Bean
    Queue queueCreateEmployee(){return new Queue(queueAuth);}

    @Bean
    public Binding bindingCreateEmployee(final Queue queueCreateEmployee, final DirectExchange exchangeAuth){
        return BindingBuilder.bind(queueCreateEmployee).to(exchangeAuth).with(keyAuth);
    }

}
