package com.example.activemq;

import org.springframework.lang.NonNull;

public class StringMessage {
    private String msg;

    public StringMessage(@NonNull String msg) {
        this.msg = msg;
    }

    public String get() {
        return msg;
    }

    public void set(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return String.format("StringMessage{msg=\"%s\"}", msg);
    }
}
