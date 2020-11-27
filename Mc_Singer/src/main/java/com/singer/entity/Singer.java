package com.singer.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "singer")
@Data
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

}
