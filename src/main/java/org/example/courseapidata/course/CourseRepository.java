package org.example.courseapidata.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    // getAllTopic;
    // getTopic(stirng id);
    // updateTopic(Topic t);
    // deleteTopic(Stirng id);

    public List<Course> findByTopicId(UUID topicId);
    public List<Course> findByName(String name);
    public List<Course> findByDiscription(String description);
}
