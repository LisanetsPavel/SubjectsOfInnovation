package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by pc8 on 15.04.16.
 */
@Entity
@Table(name = "membership", catalog = "InnovInfr")
public class Membership {

    private Long id;
    private String name;
    @JsonIgnore
    private Set<Organization> organizations;
    @JsonIgnore
    private Set<Subject> subjects;

    @Id
    @SequenceGenerator(name = "MySequence", sequenceName = "my_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MySequence")
    @Column(name = "membership_id")
    public Long getId() {
        return  id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "membership")
    @JsonIgnore
    public Set<Organization> getOrganizations() {
        return organizations;
    }

    @JsonIgnore
    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "membership_subject", catalog = "InnovInfr", joinColumns = {
            @JoinColumn(name = "membership_id", nullable =  false)
    }, inverseJoinColumns = {@JoinColumn(name = "subject_id", nullable = false)})
    @JsonIgnore
    public Set<Subject> getSubjects() {
        return subjects;
    }
    @JsonIgnore
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
