package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employee", schema = "", catalog = "relationship")
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
    private Integer year;

    @Column(name = "model", nullable = false, length = 20)
    private String model;


    @ManyToMany
    @JoinTable(name = "employee_car",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    @Singular
    private List<Employee> employeers;

}
