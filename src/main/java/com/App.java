package com;

import com.dao.MembershipDao;
import com.dao.OrganizationDao;
import com.dao.PhaseDao;
import com.dao.implement.*;
import com.entity.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pc8 on 14.04.16.
 */
public class App {
    public static void main(String[] args) {

     Set<Scope> scopes = new HashSet<>();
     Scope scope = new Scope();
     scope.setName("FourthScope");
     new ScopeDaoImpl().setScope(scope);
     scopes.add(scope);

     Set<Phase> phases = new HashSet<>();
     Phase phase = new Phase();
     phase.setName("FourthPhase");
     new PhaseDaoImpl().setPhase(phase);
     phases.add(phase);


     Subject subject = new Subject();
     subject.setName("FourthSubject");
     new SubjectDaoImpl().setSubject(subject);

     Location location = new Location();
     location.setName("Fourthlocation");
     new LocationDaoImpl().setLocation(location);

     Membership membership = new Membership();
     membership.setName("FourthMembership");
     new MembershipDaoImpl().setMembership(membership);

     Organization organization = new Organization();
     organization.setFullName("FourthOrg");
     organization.setEmail("email@TFourth");
     organization.setLocation(location);
     organization.setMembership(membership);
     organization.setSubject(subject);
     organization.setPhases(phases);
     organization.setScopes(scopes);

     OrganizationDao organizationDao = new OrganizationDaoImpl();
        organizationDao.setOrganization(organization);

    }
}
