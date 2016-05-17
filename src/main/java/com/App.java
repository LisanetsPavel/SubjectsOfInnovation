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

//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        session.beginTransaction();
//
//        Set<Phase> phases = new HashSet<Phase>();
//        Phase phase = new Phase();
//        new PhaseDaoImpl().setPhase(phase);
//        phase.setName("PhaseTest");
//        phases.add(phase);
//
//        Set<Scope> scopes = new HashSet<Scope>();
//        Scope scope = new Scope();
//        new ScopeDaoImpl().setScope(scope);
//        scope.setName("ScopeTest");
//        scopes.add(scope);
//
//        Membership membership = new Membership();
//        membership.setName("dddd");
//        new MembershipDaoImpl().setMembership(membership);
//
//
//
//        Organization organization = new Organization();
//        organization.setFullName("CNLUUU");
//        organization.setEmail("chhh@com");
//        OrganizationDao organizationDao = new OrganizationDaoImpl();
//
//        organization.setScopes(scopes);
//        organization.setPhases(phases);
//        organization.setMembership(membership);
//        organizationDao.setOrganization(organization);

        System.out.println(new ScopeDaoImpl().getScopeById(new Long(12)).getOrganizations());

        //       organizationDao.setOrganization(organization);
//
//        Membership membership = new Membership();
//        membership.setName("Membership");
//        MembershipDao membershipDao = new MembershipDaoImpl();
//        membershipDao.setMembership(membership);
//
//        organization.setMembership(membership);
//
//        organizationDao.setOrganization(organization);
//
//        System.out.println(organizationDao.getAllOrganizations());

      //  MembershipDao membershipDao = new MembershipDaoImpl();
        System.out.println("App : " +  new MembershipDaoImpl().getMembershipByName("Membership1"));



        // List<Organization> organizations = organizationDao.getOrganizationsByMembership(new Long(14));
        //System.out.println(organizations);



//        organization.setPhases(phases);
//        organization.setScopes(scopes);
//        organization.setMembership(membership);
//        session.save(organization);
//        session.getTransaction().commit();

//        PhaseDao phaseDao = new PhaseDaoImpl();




    }
}
