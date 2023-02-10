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

    private String keyMail = "key-mail";
    private String queueMail = "queue-auth-mail";

    @Bean
    DirectExchange exchangeAuth(){return new DirectExchange(exchangeAuth);}

    @Bean
    Queue queueCreateEmployee(){return new Queue(queueAuth);}

    @Bean
    Queue queueMail(){return new Queue(queueMail);}

    @Bean
    public Binding bindingCreateEmployee(final Queue queueCreateEmployee, final DirectExchange exchangeAuth){
        return BindingBuilder.bind(queueCreateEmployee).to(exchangeAuth).with(keyAuth);
    }

    @Bean
    public Binding bindingMail(final Queue queueMail, final DirectExchange exchangeAuth){
        return BindingBuilder.bind(queueMail).to(exchangeAuth).with(keyMail);
    }

}
