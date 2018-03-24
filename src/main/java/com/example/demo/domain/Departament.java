package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departament",schema = "", catalog = "relationship")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class Departament {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(mappedBy = "divisions", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Singular
    private List<Employee> employees;
}
