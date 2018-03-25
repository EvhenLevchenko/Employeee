package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "departament")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class Departament  implements Serializable{
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(mappedBy = "departaments", cascade = CascadeType.ALL)
    @Singular
    private Set<Employee> employees;
}
