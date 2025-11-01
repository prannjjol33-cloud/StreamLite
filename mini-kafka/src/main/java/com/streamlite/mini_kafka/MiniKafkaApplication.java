package com.streamlite.mini_kafka;

import com.streamlite.mini_kafka.broker.Broker;
import com.streamlite.mini_kafka.threads.ConsumerWorker;
import com.streamlite.mini_kafka.threads.ProducerWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniKafkaApplication {

	public static void main(String[] args) {

//        SpringApplication.run(MiniKafkaApplication.class, args);

        Broker broker = new Broker();
        broker.createTopic("orders",2);

        Thread producer = new Thread(new ProducerWorker(broker,"orders",100), "Producer");
        Thread consumer1 = new Thread(new ConsumerWorker(broker.getPartition("orders",0),"C1"));
        Thread consumer2 = new Thread(new ConsumerWorker(broker.getPartition("orders",1),"C2"));

        producer.start();
        consumer1.start();
        consumer2.start();
	}

}
