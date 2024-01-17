package org.example.courseapidata.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    // getAllTopic;
    // getTopic(stirng id);
    // updateTopic(Topic t);
    // deleteTopic(Stirng id);

    public List<Course> findByTopicId(String topicId);
    public List<Course> findByName(String name);
    public List<Course> findByDiscription(String description);
}
