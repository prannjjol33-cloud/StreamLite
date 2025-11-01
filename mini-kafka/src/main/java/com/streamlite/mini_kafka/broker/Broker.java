package com.streamlite.mini_kafka.broker;

import com.streamlite.mini_kafka.model.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Broker {
    private final BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

    public void produce(Message msg) throws InterruptedException{
        queue.put(msg);
        System.out.println("[BROKER] Produced: "+ msg.getValue());
    }

    public Message consume() throws InterruptedException{
        Message msg = queue.take();
        System.out.println("[BROKER] Consumed: "+ msg.getValue());
        return msg;
    }
}
