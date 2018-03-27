package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Entity
@Table(name = "car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
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
