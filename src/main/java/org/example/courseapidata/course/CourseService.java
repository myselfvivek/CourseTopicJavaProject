package org.example.courseapidata.course;

import org.example.courseapidata.course.exception.CourseAlreadyExistException;
import org.example.courseapidata.course.exception.CourseNotFoundException;
import org.example.courseapidata.topic.Topic;
import org.example.courseapidata.topic.TopicRepository;
import org.example.courseapidata.topic.TopicService;
import org.example.courseapidata.topic.exception.TopicNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;

    public List<Course> getAllCourses(UUID topicId)
    {
        Topic topic = topicRepository.findById(topicId).orElse(null);
//        System.out.println(topic);
        if(topic == null)
        {
            throw new TopicNotFound("topic not found.");
        }

        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);

//        if(courses.isEmpty())
//        {
//            throw new CourseNotFoundException("Course does not exist.");
//        }

        return courses;
    }
    public Course getCourse(UUID id, UUID topicId)
    {
        Topic topic = topicRepository.findById(topicId).orElse(null);
        if(topic == null)
        {
            throw new TopicNotFound("topic not found.");
        }

        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(course -> {
            if (course.getId().equals(id)) {
                courses.add(course);
            }
        });

        if (courses.isEmpty()) {
            throw new CourseNotFoundException("Course Not Exist.");
        }

        return courses.get(0);
    }

    public Course addCourse(Course course, UUID topicId) {
//        topics.add(topic);
//        if(courseRepository.existsById(course.getId()))
//        {
//            throw new CourseAlreadyExistException("Course Already Exists.");
//        }
        Topic topic = topicRepository.findById(topicId).orElse(null);
        System.out.println(topic);
        if(topic == null)
        {
            throw new TopicNotFound("topic not found.");
        }

        course.setTopic(topic);
        Course savedCourse = courseRepository.save(course);
        return savedCourse;
    }

    public void updateCourse(Course course, UUID topicId) {

        Topic topic = topicRepository.findById(topicId).orElse(null);
        if(topic == null)
        {
            throw new TopicNotFound("topic doesn't exist.");
        }
        course.setTopic(topic);
        courseRepository.save(course);
    }

    public void deleteCourse(UUID id, UUID topicId) {

        Topic topic = topicRepository.findById(topicId).orElse(null);
        if(topic == null)
        {
            throw new TopicNotFound("topic doesn't exist.");
        }
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(course -> {
            if (course.getId().equals(id)) {
                courses.add(course);
            }
        });

        if (courses.isEmpty()) {
            throw new CourseNotFoundException("Course Not Exist.");
        }
        courseRepository.deleteById(courses.get(0).getId());
    }
}
