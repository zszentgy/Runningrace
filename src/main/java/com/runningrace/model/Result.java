package com.runningrace.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "runner_id")
    private Runner runner; // Links to the Runner entity

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race; // Links to the Race entity

    private int timeResult; // Time result of the runner in minutes

    // Default constructor
    public Result() {
    }

    // Parameterized constructor to create a result with specific runner, race, and time
    public Result(Runner runner, Race race, int timeResult) {
        this.runner = runner;
        this.race = race;
        this.timeResult = timeResult;
    }

    // Getters and setters, toString, equals, and hashCode methods are generated by Lombok
}