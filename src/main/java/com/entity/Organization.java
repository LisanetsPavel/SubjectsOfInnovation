package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by pc8 on 14.04.16.
 */
@Entity
@Table(name = "organization", catalog = "InnovInfr",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email" , "full_name"}))
public class Organization implements Comparable {

    private Long id;

    private String fullName;
    private String shortName;
    private String fullNameEng;
    private String form;
    private String subordination;
    private String projects;
    private Integer code;
    private String legalAdress;
    private String factualAdress;
    private Long phoneNumber ;
    private String site;
    private String email;
    private String nameOfDirector;
    private String founder;
    private Boolean agreed ;

    private Subject subject;
    private Location location;

    private Membership membership;

    private Set<Scope> scopes;
    private Set<Phase> phases;

    @Id
    @SequenceGenerator(name = "MySequence", sequenceName = "my_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MySequence")
    @Column(name = "organization_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "agreed", columnDefinition = "false", nullable = false)
    public Boolean getAgreed() {

        return agreed == null ? false : agreed;
    }

    public void setAgreed(Boolean agreed) {
        this.agreed = agreed == null ? false : agreed;
    }

    @Column(name = "full_name" , unique = true)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "short_name")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Column(name = "full_name_eng")
    public String getFullNameEng() {
        return fullNameEng;
    }

    public void setFullNameEng(String fullNameEng) {
        this.fullNameEng = fullNameEng;
    }

    @Column(name = "form")
    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Column(name = "subordination")
    public String getSubordination() {
        return subordination;
    }

    public void setSubordination(String subordination) {
        this.subordination = subordination;
    }

    @Column(name = "projects")
    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    @Column(name = "code")
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Column(name = "legal_adress")
    public String getLegalAdress() {
        return legalAdress;
    }

    public void setLegalAdress(String legalAdress) {
        this.legalAdress = legalAdress;
    }

    @Column(name = "factual_adress")
    public String getFactualAdress() {
        return factualAdress;
    }

    public void setFactualAdress(String factualAdress) {
        this.factualAdress = factualAdress;
    }

    @Column(name = "phone_number")
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "site")
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Column(name = "email" , unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "name_of_director")
    public String getNameOfDirector() {
        return nameOfDirector;
    }

    public void setNameOfDirector(String nameOfDirector) {
        this.nameOfDirector = nameOfDirector;
    }

    @Column(name = "name_of_founder")
    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
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
    @JoinColumn(name = "location_id")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "membership_id")
    public Membership getMembership() {
        return membership;
    }

    @JoinColumn
    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "organization_scope", catalog = "InnovInfr", joinColumns = {
            @JoinColumn(name = "organization_id", nullable =  false)
    }, inverseJoinColumns = {@JoinColumn(name = "scope_id", nullable = false)})
    public Set<Scope> getScopes() {
        return scopes;
    }

    public void setScopes(Set<Scope> scopes) {
        this.scopes = scopes;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "organization_phase", catalog = "InnovInfr", joinColumns = {
            @JoinColumn(name = "organization_id", nullable =  false)
    }, inverseJoinColumns = {@JoinColumn(name = "phase_id", nullable = false)})
    public Set<Phase> getPhases() {
        return phases;
    }

    public void setPhases(Set<Phase> phases) {
        this.phases = phases;
    }


    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", fullNameEng='" + fullNameEng + '\'' +
                ", form='" + form + '\'' +
                ", subordination='" + subordination + '\'' +
                ", projects='" + projects + '\'' +
                ", code=" + code +
                ", legalAdress='" + legalAdress + '\'' +
                ", factualAdress='" + factualAdress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", site='" + site + '\'' +
                ", email='" + email + '\'' +
                ", nameOfDirector='" + nameOfDirector + '\'' +
                ", founder='" + founder + '\'' +
//                ", subject=" + subject +
//                ", location=" + location +
                ", membership=" + membership +


                '}';
    }

    @Override
    public int compareTo(Object o) {
        Organization organization;
        if (o instanceof Organization){
            organization = (Organization) o;
        } else{
            return 1;
        }
        if (this.shortName != null && organization.getShortName() != null){
            return this.shortName.compareTo(organization.getShortName());
        } else if ((this.fullName != null && organization.getFullName() != null )){
            return this.fullName.compareTo(organization.getFullName());
        }

       return 0;
    }


}
