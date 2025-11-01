package com.streamlite.mini_kafka.broker;

import com.streamlite.mini_kafka.model.Message;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private final String name;
    private final List<Partition> partitions;

    public Topic(String name, int numPartitions) {
        this.name = name;
        this.partitions = new ArrayList<>();

        for(int i=0;i<numPartitions;i++){
            partitions.add(new Partition(i));
        }
    }

    public String getName() {
        return name;
    }

    public List<Partition> getPartitions() {
        return partitions;
    }

    public void produce(Message msg) throws InterruptedException {
        int partitionIndex = Math.abs(msg.getKey().hashCode())%partitions.size();
        partitions.get(partitionIndex).put(msg);
    }
}
