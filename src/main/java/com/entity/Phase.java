package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by pc8 on 14.04.16.
 */
@Entity
@Table(name = "phase", catalog = "InnovInfr" )
public class Phase {

    private Long id;
    private String name;
    @JsonIgnore
    private Set<Organization> organizations;
    private Set<Article> articles;

    @Id
    @SequenceGenerator(name = "MySequence", sequenceName = "my_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MySequence")
    @Column(name = "phase_id")
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

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "phases")
    @JsonIgnore
    public Set<Organization> getOrganizations() {
        return organizations;
    }

    @JsonIgnore
    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "phase")
    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
