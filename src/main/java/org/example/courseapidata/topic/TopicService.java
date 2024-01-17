package org.example.courseapidata.topic;

import org.example.courseapidata.topic.exception.TopicAlreadyExist;
import org.example.courseapidata.topic.exception.TopicNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

@Service
public class TopicService {

    @Autowired  // for dependency injection
    private TopicRepository topicRepository;
//    it makes singlton object
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("Java", "Java Spring", "It is java spring boot."),
//            new Topic("Javascript", "Java Script here", "It is a java script.")
//    ));

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

    public Topic getTopic(String id) throws TopicNotFound
    {
        Topic topic;
        if(topicRepository.findById(id).isEmpty())
        {
            throw new TopicNotFound("topic not Found");
        }
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        else {
            topic = topicRepository.findById(id).get();
        }
        return topic;
    }

    public Topic addTopic(Topic topic) {
//        topics.add(topic);

        if(topicRepository.existsById(topic.getId()))
        {
            throw new TopicAlreadyExist("Topic already exist.");
        }
        Topic addedTopic = topicRepository.save(topic);
        return addedTopic;
    }

    public Topic updateTopic(Topic topic, String id) {

        if(!topicRepository.existsById(id))
        {
            throw new TopicNotFound("Topic not found.");
        }
        Topic updatedTopic = topicRepository.save(topic);
        return updatedTopic;
    }
    public void deleteTopic(String id) {

        if(!topicRepository.existsById(id))
        {
            throw new TopicNotFound("Topic not found.");
        }
        topicRepository.deleteById(id);
    }
}
