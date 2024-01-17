package org.example.courseapidata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
//    it makes singlton object
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("Java", "Java Spring", "It is java spring boot."),
//            new Topic("Javascript", "Java Script here", "It is a java script.")
//    ));

    public List<Course> getAllCourses(String topicId)
    {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }
    public Course getCourse(String id, String topicId)
    {
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//        ArrayList<Course> courses = new ArrayList<>();
//        courseRepository.findByTopicId(topicId).forEach(courses::add);
//        for(int i = 0; i < courses.size(); i++)
//        {
//            if(courses.get(i).getId().equals(id)) return courses.get(i);
//        }
//        return null;
//
        return courseRepository.findByTopicId(topicId).stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addCourse(Course course) {
//        topics.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {

//        for(int i = 0; i < topics.size(); i++)
//        {
//            if(topics.get(i).getId().equals(id))
//            {
//                topics.set(i, topic);
//                return;
//            }
//        }

        courseRepository.save(course);
    }

    public void deleteCourse(String id) {

        courseRepository.deleteById(id);
    }
}
