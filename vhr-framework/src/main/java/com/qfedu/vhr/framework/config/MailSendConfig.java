package com.qfedu.vhr.framework.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author weepppp 2022/8/11 19:05
 **/
@Configuration
public class MailSendConfig {

    public static final String MAIL_SEND_QUEUE_NAME = "mail_send_queue_name";
    public static final String MAIL_SEND_EXCHANGE_NAME = "mail_send_exchange_name";

    @Bean
    Queue mailSendQueue(){
        return new Queue(MAIL_SEND_QUEUE_NAME,true,false,false);
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(MAIL_SEND_EXCHANGE_NAME,true,false);
    }

    @Bean
    Binding MailSendBinding(){
        return BindingBuilder.bind(mailSendQueue()).to(directExchange()).with(MAIL_SEND_QUEUE_NAME);
    }
}
