package com.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by pc8 on 14.04.16.
 */
@Entity
@Table(name = "subject", catalog = "InnovInfr")
public class Subject implements Comparable {

    private Long id;
    private String name;
    private String url;
    private Set<Organization> organizations;
    private Set<Membership> memberships;

    @Id
    @SequenceGenerator(name = "MySequence", sequenceName = "my_seq", allocationSize=1 )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MySequence")
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
    public Set<Organization> getOrganizations() {
        return organizations;
    }

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

    @Override
    public int compareTo(Object o) {
        Subject subject;
        if (o instanceof Subject){
            subject = (Subject) o;
        } else {
            return 1;
        }

        if (this.getOrganizations() != null && subject.getOrganizations() != null){
            if(this.getOrganizations().size() > subject.getOrganizations().size()){
                return 1;
            } else if (this.getOrganizations().size() < subject.getOrganizations().size()){
                return -1;
            }
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;

        Subject subject = (Subject) o;

        if (id != null ? !id.equals(subject.id) : subject.id != null) return false;
        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
        if (url != null ? !url.equals(subject.url) : subject.url != null) return false;
        if (organizations != null ? !organizations.equals(subject.organizations) : subject.organizations != null)
            return false;
        return !(memberships != null ? !memberships.equals(subject.memberships) : subject.memberships != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (organizations != null ? organizations.hashCode() : 0);
        result = 31 * result + (memberships != null ? memberships.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                /*", organizations=" + organizations +
                ", memberships=" + memberships +*/
                '}';
    }
}
