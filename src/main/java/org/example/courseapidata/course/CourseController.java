package org.example.courseapidata.course;

import org.example.courseapidata.topic.Topic;
import org.example.courseapidata.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/topics/{id}/courses")
    @Cacheable(value = "topics", key = "#id")
    public List<Course> getAllCourses(@PathVariable UUID id){

        return courseService.getAllCourses(id);
    }
    @GetMapping("/topics/{topicId}/courses/{id}")
    @Cacheable(value = "courses", key = "#id")
    public Course getCourse(@PathVariable UUID id, @PathVariable UUID topicId){
        return courseService.getCourse(id, topicId);
    }

    @PostMapping( "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable UUID topicId)
    {
        courseService.addCourse(course, topicId);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    @CachePut(value = "courses", key = "#id")
    public void updateCourse(@RequestBody Course course, @PathVariable UUID topicId, @PathVariable UUID id)
    {
//        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course, topicId);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    @CacheEvict(value = "courses", key = "#id", beforeInvocation = true)
    public void deleteCourse(@PathVariable UUID id, @PathVariable UUID topicId)
    {
        courseService.deleteCourse(id, topicId);
    }
}
