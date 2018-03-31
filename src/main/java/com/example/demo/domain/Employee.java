package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Table(name = "employee")
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})//Lazy при загрузке сущности PERM не загружает кол-ю сразу а только при данном обращении к ней
    @JoinTable(name = "employee_departament",
            joinColumns = {@JoinColumn(name = "employeeId")},
            inverseJoinColumns = {@JoinColumn(name = "departamentId")})//TODO add referencesColumnName. Warning exception create bean?
    @Singular
    private List<Departament> departaments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "employee_car",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    @Singular
    private List<Car> cars;
}
