package org.example.courseapidata.topic.exception;

public class TopicAlreadyExist extends RuntimeException{
    private String message;
    public TopicAlreadyExist(String message)
    {
        super(message);
        this.message = message;
    }
    public TopicAlreadyExist(){}
}
