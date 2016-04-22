package com.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by pc8 on 14.04.16.
 */
@Entity
@Table(name = "scope", catalog = "InnovInfr")
public class Scope {

    private Long id;
    private String name;
    private Set<Organization> organizations;


    @Id
    @SequenceGenerator(name = "MySequence", sequenceName = "my_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MySequence")
    @Column(name = "scope_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "scopes")
    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return "Scope{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organizations=" + organizations +
                '}';
    }
}
