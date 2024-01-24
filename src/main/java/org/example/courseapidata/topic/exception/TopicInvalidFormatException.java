package org.example.courseapidata.topic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TopicInvalidFormatException extends RuntimeException {

    private String message;

    public TopicInvalidFormatException(){}

    public TopicInvalidFormatException(String message)
    {
        super(message);
        this.message = message;
    }

}
