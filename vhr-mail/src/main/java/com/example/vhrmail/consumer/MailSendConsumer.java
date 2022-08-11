package com.example.vhrmail.consumer;

import com.qfedu.vhr.framework.config.MailSendConfig;
import com.qfedu.vhr.framework.entity.vo.EmployeeDTO;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailSendConsumer {

    @Autowired
    RedisTemplate redisTemplate;

    @RabbitListener(queues = MailSendConfig.MAIL_SEND_QUEUE_NAME)
    public void handleMsg(Message message, Channel channel) throws IOException {
        EmployeeDTO employeeDTO = (EmployeeDTO) message.getPayload();
        System.out.println(employeeDTO);
        //获取消息的唯一id
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
//        String correlationId = (String) message.getHeaders().get(AmqpHeaders.CORRELATION_ID);
        if (redisTemplate.opsForHash().hasKey("mail_send_log", employeeDTO.getId())) {
            //如果存在，说明这个消息已经消费过了
            //直接扔了当前消息即可
            channel.basicNack(deliveryTag, false, false);
        }else{
            System.out.println("发送邮件。。。");
            //将数据存入 Redis，这样下次就不会被重复消费了
            redisTemplate.opsForHash().put("mail_send_log", employeeDTO.getId(), employeeDTO.getId());
            channel.basicAck(deliveryTag, false);
        }

    }
}

