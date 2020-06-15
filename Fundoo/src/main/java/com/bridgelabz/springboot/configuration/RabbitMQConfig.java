package com.bridgelabz.springboot.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import io.lettuce.core.dynamic.annotation.Value;

@Configuration
public class RabbitMQConfig {
	
	@Value("${spring.rabbitmq.queue}")
	String queueName;
	
	@Value("${spring.rabbitmq.exchange}")
	String exchange;
	
	@Value("${spring.rabbitmq.routingkey}")
	String routingkey;
	
	@Value("${spring.rabbitmq.username}")
	String username;
	
	@Value("${spring.rabbitmq.password}")
	String password;
	
	@Bean
	DirectExchange directExchange() {
		return new DirectExchange(exchange);
	}
	
	@Bean
	Binding bindingQueueExchange(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingkey);
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setConnectionFactory(connectionFactory);
		return rabbitTemplate;
	}
}
