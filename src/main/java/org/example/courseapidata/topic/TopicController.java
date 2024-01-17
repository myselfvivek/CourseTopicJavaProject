package org.example.courseapidata.topic;


import org.example.courseapidata.topic.exception.TopicAlreadyExist;
import org.example.courseapidata.topic.exception.TopicNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


// ...

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;
    @RequestMapping("/topics")
    public ResponseEntity<Object> getAllTopics(){
        try {
            Object topics = topicService.getAllTopics();
            return ResponseEntity.ok(topics);
        }catch(TopicNotFound topicNotFoundException){
            String errorMessage = "There are no topics.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }catch(Exception e){
            String errorMessage = "An unexpected error occurred.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
//        return topicService.getAllTopics();
    }
    @RequestMapping("/topics/{id}")
    public ResponseEntity<Object> getTopic(@PathVariable String id) {
        try {
            Object topic = topicService.getTopic(id);
            return ResponseEntity.ok(topic);
        } catch (TopicNotFound topicNotFoundException) {
            String errorMessage = "Topic not found for id: " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (Exception e) {
            String errorMessage = "An unexpected error occurred";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public ResponseEntity<Object> addTopic(@RequestBody Topic topic) throws TopicAlreadyExist
    {
        try{
            Topic savedTopic =  topicService.addTopic(topic);
//            return new ResponseEntity<>(savedTopic, HttpStatus.CREATED);
            return ResponseEntity.ok(savedTopic);
        }
        catch(TopicAlreadyExist topicAlreadyExistException){
            String errorMessage = "Topic Already exist with id: " + topic.getId();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }catch(Exception e)
        {
            String errorMessage = "An unexpected error occurred";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public ResponseEntity<Object> updateTopic(@RequestBody Topic topic, @PathVariable String id) throws TopicNotFound
    {
        try{
            Topic updateTopic = topicService.updateTopic(topic, id);
            return ResponseEntity.ok(updateTopic);
//            return ResponseEntity.status(updateTopic, HttpStatus.CREATED);
        }
        catch(TopicNotFound topicNotFoundExcaption)
        {
            String errorMessage = "Topic not found with id: " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        catch(Exception e)
        {
            String errorMessage = "An unexpected error occurred";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
//        return topicService.updateTopic(topic, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public ResponseEntity<Object> deleteTopic(@PathVariable String id) throws TopicNotFound
    {
        try{
            topicService.deleteTopic(id);
            return ResponseEntity.ok("deleted succesfully.");
        }
        catch(TopicNotFound topicNotFoundExcaption)
        {
            String errorMessage = "Topic not found with id: " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        catch(Exception e)
        {
            String errorMessage = "An unexpected error occurred";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
