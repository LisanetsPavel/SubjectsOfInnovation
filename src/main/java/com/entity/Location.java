package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by pc8 on 14.04.16.
 */
@Entity
@Table(name = "location", catalog = "InnovInfr")
public class Location implements Comparable {

    private Long id;
    private String name;
    @JsonIgnore
    private Set<Organization> organizations;

    @Id
    @SequenceGenerator(name = "MySequence", sequenceName = "my_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MySequence")
    @Column(name = "location_id")
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "location")
    @JsonIgnore
    public Set<Organization> getOrganizations() {
        return organizations;
    }

    @JsonIgnore
    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public int compareTo(Object o) {
        Location location;
        if (o instanceof  Location){
            location = (Location) o;
        } else{
            return 1;
        }

        if (this.name != null && location.getName() != null){
            return this.name.compareTo(location.getName());
        }

        return 0;
    }
}
