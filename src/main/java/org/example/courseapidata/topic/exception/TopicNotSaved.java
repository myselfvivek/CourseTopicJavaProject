package org.example.courseapidata.topic.exception;

public class TopicNotSaved extends RuntimeException{

    private String message;

    public TopicNotSaved(){};
    public TopicNotSaved(String message){
        super(message);
        this.message = message;
    };

}
