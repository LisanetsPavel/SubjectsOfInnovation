package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by pc8 on 14.04.16.
 */
@Entity
@Table(name = "subject", catalog = "InnovInfr")
public class Subject {

    private Long id;
    private String name;
    private String url;
    @JsonIgnore
    private Set<Organization> organizations;
    private Set<Membership> memberships;
    private Set<Article> articles;

    @Id
    @SequenceGenerator(name = "MySequence", sequenceName = "my_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MySequence")
    @Column(name = "subject_id")
    public Long getId() {
        return id;
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

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subject")
    @JsonIgnore
    public Set<Organization> getOrganizations() {
        return organizations;
    }

    @JsonIgnore
    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "subjects")
    public Set<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(Set<Membership> memberships) {
        this.memberships = memberships;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subject")
    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
