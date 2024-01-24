package org.example.courseapidata.topic;



import org.example.courseapidata.topic.exception.TopicAlreadyExist;
import org.example.courseapidata.topic.exception.TopicNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;


    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }
    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
    @Cacheable(value = "topics", key = "#id")
    public Topic getTopic(@PathVariable UUID id) {
        return topicService.getTopic(id);
    }
    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic) throws TopicAlreadyExist {
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    @CachePut(value = "topics", key = "#id")
    public void updateTopic(@RequestBody Topic topic, @PathVariable UUID id) throws TopicNotFound {
        topicService.updateTopic(topic, id);
    }

    @DeleteMapping("/topics/{id}")
    @CacheEvict(value = "topics", key = "#id", beforeInvocation = false)
    public void deleteTopic(@PathVariable UUID id) throws TopicNotFound {
        topicService.deleteTopic(id);
    }
}
