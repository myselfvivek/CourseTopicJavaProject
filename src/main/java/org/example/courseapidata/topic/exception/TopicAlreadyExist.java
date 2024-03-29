package org.example.courseapidata.topic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TopicAlreadyExist extends RuntimeException{
    private String message;
    public TopicAlreadyExist(String message)
    {
        super(message);
        this.message = message;
    }
    public TopicAlreadyExist(){}
}
