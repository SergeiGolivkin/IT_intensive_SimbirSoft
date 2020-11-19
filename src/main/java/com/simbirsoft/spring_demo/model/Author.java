package com.simbirsoft.spring_demo.model;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisherId", referencedColumnName = "id")
    private Publisher publisher ;

    @Column(name ="firstName")
    private String firstName;

    @Column(name ="lastName")
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publisher getPublisher() {
        return publisher;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}