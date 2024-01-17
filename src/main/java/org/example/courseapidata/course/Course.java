package org.example.courseapidata.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.example.courseapidata.topic.Topic;

@Entity
@Table
public class Course {

    @Id
    private String id;
    private String name;
    private String discription;

    @ManyToOne
    private Topic topic;
    public Course(){

    }
    public Course(String id, String name, String description, String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.discription = description;
        this.topic = new Topic(topicId, "", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
