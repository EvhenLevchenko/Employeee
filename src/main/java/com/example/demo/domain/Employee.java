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
@ToString
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinTable(name = "employee_and_departament",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "departament_id")})
    @Singular
    private List<Departament> departaments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_car",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    @Singular
    private List<Car> cars;
}
