package com.streamlite.mini_kafka.threads;

import com.streamlite.mini_kafka.broker.Broker;
import com.streamlite.mini_kafka.model.Message;

public class ConsumerWorker implements Runnable{
    private final Broker broker;
    private final String name;

    public ConsumerWorker(Broker broker, String name) {
        this.broker = broker;
        this.name = name;
    }

    @Override
    public void run(){
        try {
            while (true){
                Message msg = broker.consume();
                System.out.println("[CONSUMER- "+ name +"] processed: "+ msg.getValue());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
