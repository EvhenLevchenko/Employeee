package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "car")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Car implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "year", nullable = false, length = 4)
    private int year;

    @Column(name = "model", nullable = false, length = 20)
    private String model;


    @ManyToMany(mappedBy = "cars", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Singular
    private Set<Employee> employees;

}
