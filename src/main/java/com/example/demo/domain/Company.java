package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
public class Company implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "size", nullable = false, length = 5)
    private int size;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Singular
    private List<Departament> departaments;


}
