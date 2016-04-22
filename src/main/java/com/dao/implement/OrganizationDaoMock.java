package com.dao.implement;

import com.dao.OrganizationDao;
import com.entity.Organization;
import com.entity.Phase;
import com.entity.Scope;
import com.entity.Subject;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pc8 on 20.04.16.
 */
@Repository
public class OrganizationDaoMock implements OrganizationDao {
    @Override
    public void setOrganization(Organization organization) {

    }

    public List<Organization> getAllOrganizations() {
        List<Organization> resultList = new ArrayList<>();
        Organization organization = new Organization();
        Organization organization1 = new Organization();
        Organization organization2 = new Organization();
        Subject subject = new Subject();
        subject.setName("sub");

        Subject subject2 = new Subject();
        subject2.setName("sub2");


        Scope scope = new Scope();
        scope.setName("sco");
        Set<Scope> scopeSet = new HashSet<>();
        scopeSet.add(scope);
        Scope scope2 = new Scope();
        scope2.setName("sco2");


        Phase phase = new Phase();
        phase.setName("pha");
        Set<Phase> phaseSet = new HashSet<>();
        phaseSet.add(phase);
        Phase phase2 = new Phase();
        phase2.setName("pha2");

        organization.setFullName("org");
        organization.setScopes(scopeSet);
        organization.setSubject(subject);
        organization.setPhases(phaseSet);

        organization1.setFullName("Aaaaaaaaaaa");
        organization1.setSubject(subject);
        Set<Scope> scopeSet3 = new HashSet<>();
        scopeSet3.add(scope);
        scopeSet3.add(scope2);
        organization1.setScopes(scopeSet3);

        Set<Phase> phaseSet3 = new HashSet<>();
        phaseSet3.add(phase2);
        phaseSet3.add(phase);
        organization1.setPhases(phaseSet3);


        organization2.setFullName("bbbbbbbbbbbbb");
        organization2.setSubject(subject2);
        Set<Scope> scopeSet2 = new HashSet<>();
        scopeSet2.add(scope2);
        organization2.setScopes(scopeSet2);


        Set<Phase> phaseSet2 = new HashSet<>();
        phaseSet2.add(phase2);
        organization2.setPhases(phaseSet2);


        resultList.add(organization);
        resultList.add(organization1);
        resultList.add(organization2);
        return resultList;

    }

    @Override
    public Organization getOrganizationById(Long organizationId) {

        return null;
    }

    @Override
    public Set<Organization> getOrganizationsBySubject(Long subjectId) {

        com.entity.Subject subject = new Subject();
        subject.setName("аааа");
        com.entity.Subject subjectTwo = new Subject();
        subject.setName("Ббббббб");
        Organization organization = new Organization();
        organization.setFullName("NLU");
        organization.setSubject(subject);
        Organization organizationTwo = new Organization();
        organizationTwo.setFullName("BKnure");
        organizationTwo.setSubject(subject);
        Organization organizationThree = new Organization();
        organizationThree.setFullName("AKnure");
        organizationThree.setSubject(subject);

        Set<Organization> set = new HashSet<>();
        set.add(organization);
        set.add(organizationTwo);
        set.add(organizationThree);
        return set;
    }

    @Override
    public Set<Organization> getOrganizationsByLocation(Long locationId) {
        return null;
    }

    @Override
    public Set<Organization> getOrganizationsByMembership(Long membershipId) {
        return null;
    }

    @Override
    public Set<Organization> getOrganizationsByScope(Long scopeId) {
        return null;
    }

    @Override
    public Set<Organization> getOrganizationsByPhase(Long phaseId) {
        return null;
    }
}
