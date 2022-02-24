package com.example.bookclub.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "posts")
public class post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column
    private String name;

    @Column
    private String body;

//    https://stackoverflow.com/questions/54840769/how-to-persist-localdate-with-jpa
    @Column(columnDefinition = "DATE")
    private LocalDate date;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;



}
