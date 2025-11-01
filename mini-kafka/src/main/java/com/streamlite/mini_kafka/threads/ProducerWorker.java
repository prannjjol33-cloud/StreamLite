package com.streamlite.mini_kafka.threads;

import com.streamlite.mini_kafka.broker.Broker;
import com.streamlite.mini_kafka.model.Message;

public class ProducerWorker implements Runnable{
    private final Broker broker;
    private final String topic;
    private final int msgCount;

    public ProducerWorker(Broker broker, String topic, int msgCount) {
        this.broker = broker;
        this.topic = topic;
        this.msgCount = msgCount;
    }

    @Override
    public void run(){
        try{
            for (int i=1;i<=msgCount;i++){
                Message msg = new Message("Key- " + i,"Message- " + i);
                broker.produce(topic,msg);
                Thread.sleep(20);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
