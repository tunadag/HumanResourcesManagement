package com.bilgeadam.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private String exchangeEmployee = "exchange-employee";
    private String keyEmployee = "key-employee";
    private String queueEmployee = "queue-employee-assign-director";

    @Bean
    DirectExchange exchangeEmployee(){return new DirectExchange(exchangeEmployee);}

    @Bean
    Queue queueAssignDirector(){return new Queue(queueEmployee);}

    @Bean
    public Binding bindingAssignDirector(final Queue queueAssignDirector, final DirectExchange exchangeEmployee){
        return BindingBuilder.bind(queueAssignDirector).to(exchangeEmployee).with(keyEmployee);
    }
}
