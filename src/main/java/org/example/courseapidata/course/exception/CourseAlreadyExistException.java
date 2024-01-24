package org.example.courseapidata.course.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CourseAlreadyExistException extends RuntimeException{
    private String message;
    public CourseAlreadyExistException(String message)
    {
        super(message);
        this.message = message;
    }
    public CourseAlreadyExistException(){}
}
