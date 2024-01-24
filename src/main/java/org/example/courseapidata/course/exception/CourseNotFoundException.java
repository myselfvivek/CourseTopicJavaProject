package org.example.courseapidata.course.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException{
    private String message;
    public CourseNotFoundException(){

    }
    public CourseNotFoundException(String message)
    {
        super(message);
//        this.message = message;
    }
}
