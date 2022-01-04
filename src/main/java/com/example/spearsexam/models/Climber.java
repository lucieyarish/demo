package com.example.spearsexam.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.function.BooleanSupplier;

@Getter
@Setter
@Entity
@Table(name = "climbers")
public class Climber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nationality;

    @ManyToOne
    private Mountain mountain;

    private Integer altitude = 0;
    private Boolean injured = false;

    public Climber(){}
    public Climber(Long id, String name, String nationality, Mountain mountain,
                   Integer altitude, Boolean injured) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.mountain = mountain;
        this.altitude = altitude;
        this.injured = injured;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getNationality() { return nationality; }
    public Mountain getMountain() { return mountain; }
    public Integer getAltitude() { return altitude; }
    public Boolean isInjured() { return injured; }

    public Climber(String name, String nationality, Mountain mountain, Integer altitude, Boolean injured) {
        this(null, name, nationality, mountain, altitude, injured);
    }
}
