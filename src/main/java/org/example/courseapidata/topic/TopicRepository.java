package org.example.courseapidata.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {

    // getAllTopic;
    // getTopic(stirng id);
    // updateTopic(Topic t);
    // deleteTopic(Stirng id);
//    public Topic findByTopicId(UUID topicId);
}
