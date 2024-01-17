package org.example.courseapidata.topic.exception;

public class TopicNotFound extends RuntimeException{
    private String message;
    public TopicNotFound(){

    }
    public TopicNotFound(String message)
    {
        super(message);
        this.message = message;
    }
}
