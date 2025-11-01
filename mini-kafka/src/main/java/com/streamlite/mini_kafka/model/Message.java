package com.streamlite.mini_kafka.model;

public class Message {
    private String key;
    private String value;
    private long timestamp;

    public Message() {
    }

    public Message(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Message(String key, String value, long timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
