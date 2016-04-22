package com;

import com.dao.OrganizationDao;
import com.dao.PhaseDao;
import com.dao.implement.OrganizationDaoImpl;
import com.dao.implement.PhaseDaoImpl;
import com.dao.implement.SubjectDaoImpl;
import com.entity.Subject;

/**
 * Created by pc8 on 14.04.16.
 */
public class App {
    public static void main(String[] args) {

//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        session.beginTransaction();
//
//        Set<Phase> phases = new HashSet<Phase>();
//        Phase phase = new Phase();
//        phase.setName("PhaseTest");
//        phases.add(phase);
//
//        session.save(phase);
//
//        Set<Scope> scopes = new HashSet<Scope>();
//        Scope scope = new Scope();
//        scope.setName("ScopeTest");
//        scopes.add(scope);
//
//        session.save(scope);
//
//        Membership membership = new Membership();
//        membership.setName("dddd");
//
//        session.save(membership);


//        Organization organization = new Organization();
//        organization.setFullName("NLUUU");
//        organization.setEmail("hhh@com");
        OrganizationDao organizationDao = new OrganizationDaoImpl();
//        organizationDao.setOrganization(organization);
//
//     Membership membership = new Membership();
//        membership.setId(new Long(14));
     // List<Organization> organizations = organizationDao.getOrganizationsByMembership(new Long(14));
        //System.out.println(organizations);



//        organization.setPhases(phases);
//        organization.setScopes(scopes);
//        organization.setMembership(membership);
//        session.save(organization);
//        session.getTransaction().commit();

        PhaseDao phaseDao = new PhaseDaoImpl();



    }
}
