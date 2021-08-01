package com.example.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    @JmsListener(destination = Names.DEFAULT_DESTINATION)
    public void receiveMessage(StringMessage msg) {
        System.out.println("MessageReceiver#receiveMessage(" + msg + ")");
    }
}
