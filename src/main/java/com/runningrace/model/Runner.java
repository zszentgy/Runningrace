package com.runningrace.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Runner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String gender; // Gender of the runner

    // Default constructor
    public Runner() {
    }

    // Parameterized constructor for creating a runner with name, age, and gender
    public Runner(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters and setters, toString, equals, and hashCode methods are generated by Lombok
}