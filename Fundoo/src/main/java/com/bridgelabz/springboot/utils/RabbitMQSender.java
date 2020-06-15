package com.bridgelabz.springboot.utils;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bridgelabz.springboot.model.Mail;

@Component
public class RabbitMQSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${rmq.springboot.exchange}")
	private String exchange;
	
	@Value("${rmq.springboot.routingkey}")
	private String routingKey;
	
	public void sendMail(Mail mail) {
		rabbitTemplate.convertAndSend(exchange, routingKey, mail);
	}
}
