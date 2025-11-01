package com.streamlite.mini_kafka.controller;

import com.streamlite.mini_kafka.model.Message;
import com.streamlite.mini_kafka.service.BrokerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConsumerController {

    private final BrokerService broker;

    public ConsumerController(BrokerService broker) {
        this.broker = broker;
    }

    @GetMapping("/consume")
    public Message consume(){
        return broker.consume();
    }

}
