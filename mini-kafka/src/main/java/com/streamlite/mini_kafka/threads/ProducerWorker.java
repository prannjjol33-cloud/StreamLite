package com.streamlite.mini_kafka.threads;

import com.streamlite.mini_kafka.broker.Broker;
import com.streamlite.mini_kafka.model.Message;

public class ProducerWorker implements Runnable{
    private final Broker broker;
    private final int msgCount;

    public ProducerWorker(Broker broker, int msgCount) {
        this.broker = broker;
        this.msgCount = msgCount;
    }

    @Override
    public void run(){
        try{
            for (int i=0;i<msgCount;i++){
                Message msg = new Message("Key- " + i,"Message- " + i);
                broker.produce(msg);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

}
