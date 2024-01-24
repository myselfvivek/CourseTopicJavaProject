package org.example.courseapidata.topic;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
public class Topic implements Serializable {

    private static final long serialVersionUID = -33333333333L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "topic_id", columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "topic_name", updatable = true, nullable = false)
    private String name;
    @Column(name = "topic_discription", updatable = true, nullable = true)
    private String discription;

    public Topic(){

    }
    public Topic(UUID id, String name, String discription) {
        super();
        this.id = id;
        this.name = name;
        this.discription = discription;
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
}
