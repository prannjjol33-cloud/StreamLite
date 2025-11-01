package com.streamlite.mini_kafka.broker;

import com.streamlite.mini_kafka.model.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Partition {
    private final int id;
    private final BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

    public Partition(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void put(Message msg) throws InterruptedException {
        queue.put(msg);
        System.out.println("[Partition "+ id + "] produced: "+ msg.getValue());
    }

    public Message take() throws InterruptedException {
        Message msg = queue.take();
        System.out.println("[Partition "+ id + "] consumed: "+ msg.getValue());
        return msg;
    }
}
