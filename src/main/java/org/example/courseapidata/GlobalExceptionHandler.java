package org.example.courseapidata;


import org.example.courseapidata.course.exception.CourseAlreadyExistException;
import org.example.courseapidata.course.exception.CourseNotFoundException;
import org.example.courseapidata.topic.exception.TopicAlreadyExist;
import org.example.courseapidata.topic.exception.TopicInvalidFormatException;
import org.example.courseapidata.topic.exception.TopicNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TopicNotFound.class)
    public ResponseEntity<Object> handleNoTopicsException(TopicNotFound ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TopicAlreadyExist.class)
    public ResponseEntity<Object> handleTopicAlreadyExistException(TopicAlreadyExist ex)
    {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Object> handleNoCourseException(CourseNotFoundException ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CourseAlreadyExistException.class)
    public ResponseEntity<Object> handleCourseAlreadyExistException(CourseAlreadyExistException ex)
    {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }
//    @ExceptionHandler(TopicInvalidFormatException.class)
//    public ResponseEntity<Object> handleTopicInvalidFormatException(TopicInvalidFormatException ex)
//    {
//        String errorMessage = ex.getMessage();
//        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//    }
}
