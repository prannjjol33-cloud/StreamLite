package com.streamlite.mini_kafka.broker;

import com.streamlite.mini_kafka.model.Message;

import java.util.concurrent.ConcurrentHashMap;

public class Broker {
    private final ConcurrentHashMap<String,Topic> topics = new ConcurrentHashMap<>();

    public void createTopic(String name,int numPartitions){
        topics.putIfAbsent(name, new Topic(name,numPartitions));
    }

    public void produce(String topicName, Message msg) throws InterruptedException{
        Topic topic = topics.get(topicName);
        if (topic==null) throw new IllegalArgumentException("Topic not found: " + topicName);
        topic.produce(msg);
    }

    public Partition getPartition(String topicName, int PartitionId){
        return topics.get(topicName).getPartitions().get(PartitionId);
    }

    public int getNumPartitions(String topicName){
        return topics.get(topicName).getPartitions().size();
    }

}
