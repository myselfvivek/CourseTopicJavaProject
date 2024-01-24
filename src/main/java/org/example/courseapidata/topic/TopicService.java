package org.example.courseapidata.topic;

import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.example.courseapidata.topic.exception.TopicAlreadyExist;
import org.example.courseapidata.topic.exception.TopicInvalidFormatException;
import org.example.courseapidata.topic.exception.TopicNotFound;
import org.example.courseapidata.topic.exception.TopicNotSaved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
//import java.util.Optional;

@Service
public class TopicService {

    @Autowired  // for dependency injection
    private TopicRepository topicRepository;


    public List<Topic> getAllTopics()
    {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        if(topics.isEmpty())
        {
            throw new TopicNotFound("Topics are not there.");
        }
        return topics;
    }

    public Topic getTopic(UUID id) throws TopicNotFound
    {
        if(topicRepository.findById(id).isEmpty())
        {
            throw new TopicNotFound("topic not Found");
        }
        Topic topic = topicRepository.findById(id).get();
        return topic;
    }

//    private boolean fieldExist(Class<?> clazz, String fieldName)
//    {
//        try{
//            Field field = clazz.getDeclaredField(fieldName);
//            return true;
//        } catch(NoSuchFieldException e)
//        {
//            return false;
//        }
//    }
//    public boolean inputFormatCheck(Map<String, Object> map)
//    {
//        for(Map.Entry<String, Object> entry: map.entrySet())
//        {
//            if(!fieldExist(Topic.class, entry.getKey()))
//            {
//                return false;
//            }
//        }
//        return true;
//    }
    public void addTopic(Topic topic) {

//        if(topicRepository.existsById(topic.getId()))
//        {
//            throw new TopicAlreadyExist("Topic already exist.");
//        }
//        boolean valid = inputFormatCheck(topic);
//        System.out.println("valid " + valid);
//        if(!valid)  throw new TopicInvalidFormatException("topic format is invalid.");
//
//        ObjectMapper mapper = new ObjectMapper();
//        Topic newTopic = mapper.convertValue(topic, Topic.class);
          Topic ans = topicRepository.save(topic);
          if(ans == null) {
              throw new TopicNotSaved("topic failed to save.");
          }
    }

    public void updateTopic(Topic topic, UUID id) {

        System.out.println("hie");
//        boolean valid = inputFormatCheck(topic);
        Topic eTopic = topicRepository.findById(id).orElse(null);
        if(eTopic == null)
        {
            throw new TopicNotFound("Topic is not here.");
        }
        eTopic.setDiscription(topic.getDiscription());
        eTopic.setName(topic.getName());
        topicRepository.save(eTopic);
    }

    public void deleteTopic(UUID id) {

        if(!topicRepository.existsById(id))
        {
            throw new TopicNotFound("Topic not found.");
        }
        topicRepository.deleteById(id);
    }
}
