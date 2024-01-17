package org.example.courseapidata.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

    // getAllTopic;
    // getTopic(stirng id);
    // updateTopic(Topic t);
    // deleteTopic(Stirng id);

}
