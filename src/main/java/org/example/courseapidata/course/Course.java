package org.example.courseapidata.course;

import jakarta.persistence.*;
import org.example.courseapidata.topic.Topic;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
public class Course implements Serializable {

    private static final long serialVersionUID = -33333333333L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "course_id", columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "course_name", updatable = true, nullable = false)
    private String name;
    @Column(name = "course.discription", updatable = true, nullable = true)
    private String discription;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "topic_id",
            referencedColumnName = "topic_id",
            nullable = false
    )
    private Topic topic;
    public Course(){

    }
    public Course(UUID id, String name, String description, UUID topicId) {
        super();
        this.id = id;
        this.name = name;
        this.discription = description;
        this.topic = new Topic(topicId, "", "");
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
