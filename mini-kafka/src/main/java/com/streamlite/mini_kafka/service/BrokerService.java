package com.streamlite.mini_kafka.service;

import com.streamlite.mini_kafka.model.Message;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class BrokerService {

    private final Queue<Message> queue = new LinkedList<>();

    public void produce(Message message){
        queue.offer(message);
        System.out.println("Produced: "+ message.getValue());
    }

    public Message consume(){
        Message message= queue.poll();
        System.out.println("Consumed: " + (message!=null ? message.getValue() : "No message present"));
        return message;
    }

}
