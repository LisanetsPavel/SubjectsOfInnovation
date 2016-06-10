package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by pc8 on 30.05.16.
 */
@Entity
@Table(name = "article", catalog = "InnovInfr")
public class Article {

    private Long id;
    private String link;
    @JsonIgnore
    private Subject subject;
    @JsonIgnore
    private Phase phase;
    @JsonIgnore
    private Scope scope;


    @Id
    @SequenceGenerator(name = "MySequence", sequenceName = "my_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MySequence")
    @Column(name = "article_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phase_id")
    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scope_id")
    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }
}
