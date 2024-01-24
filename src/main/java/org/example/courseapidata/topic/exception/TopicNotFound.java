package org.example.courseapidata.topic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TopicNotFound extends RuntimeException{
    private String message;
    public TopicNotFound(){

    }
    public TopicNotFound(String message)
    {
        super(message);
//        this.message = message;
    }
}
