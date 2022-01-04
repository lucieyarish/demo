package com.example.spearsexam.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "mountains")
public class Mountain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer height;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "first_ascend")
    private Date firstAscend = null;

    @OneToMany(mappedBy = "mountain")
    @OrderBy(value = "altitude")
    private List<Climber> climbers;

    //This is the same as @NoArgsConstructor
    public Mountain() {}

    //This is the same as @AllArgsConstructor
    public Mountain(Long id, String name, Integer height, Date first) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.firstAscend = first;
    }

    public Mountain(String name, Integer height) {
        this(null, name, height, null);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Integer getHeight() { return height; }
    public Date getFirstAscend() { return firstAscend; }
    public List<Climber> getClimbers() { return climbers; }

    public String getTitle() {
        return String.format("%s - %dm (level %d)", name, height, getDifficulty());
    }

    public Integer getDifficulty(){
        return (height / 1000) + 1;
    }


}
