package com.streamlite.mini_kafka.controller;

import com.streamlite.mini_kafka.model.Message;
import com.streamlite.mini_kafka.service.BrokerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerController {

    private final BrokerService broker;

    public ProducerController(BrokerService broker) {
        this.broker = broker;
    }

    @PostMapping("/produce")
    public String produce(@RequestBody Message message) {
        broker.produce(message);
        return "Message produced!!";
    }
}
