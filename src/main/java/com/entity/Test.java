package com.entity;

import javax.persistence.*;

/**
 * Created by pc8 on 14.04.16.
 */
@Entity
@Table(name = "Trololo")
public class Test {
    private int id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
