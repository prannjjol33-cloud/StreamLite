package com.streamlite.mini_kafka.threads;

import com.streamlite.mini_kafka.broker.Partition;
import com.streamlite.mini_kafka.model.Message;

public class ConsumerWorker implements Runnable{
    private final Partition partition;
    private final String name;

    public ConsumerWorker(Partition partition, String name) {
        this.partition = partition;
        this.name = name;
    }

    @Override
    public void run(){
        try {
            while (true){
                Message msg = partition.take();
                System.out.println("[CONSUMER- "+ name +"] processed: "+ msg.getValue());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
