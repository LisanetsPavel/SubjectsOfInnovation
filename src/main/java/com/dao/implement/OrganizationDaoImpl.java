package com.dao.implement;

import com.dao.OrganizationDao;
import com.entity.*;
import com.util.CloseableSession;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by pc8 on 15.04.16.
 */
@Repository
public class OrganizationDaoImpl extends GenericDao implements OrganizationDao {


    public void setOrganization(Organization organization) {
         set(organization);
    }

    public Organization getOrganizationById(Long organizationId) {

        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
            Session session = closeableSession.getSession();
            return  (Organization) session.get(Organization.class, organizationId);

        }
    }

    public Set<Organization> getOrganizationsBySubject(Long subjectId) {
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
            Session session = closeableSession.getSession();
            Subject subject = (Subject) session.get(Subject.class, subjectId);

            return  subject.getOrganizations();
        }
    }

    public Set<Organization> getOrganizationsByLocation(Long locationId) {
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
            Session session = closeableSession.getSession();
            Location location = (Location) session.get(Location.class, locationId);

            return  location.getOrganizations();
        }
    }

    public Set<Organization> getOrganizationsByMembership(Long membershipId) {
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
            Session session = closeableSession.getSession();
            Membership member = (Membership) session.get(Membership.class, membershipId);

            return  member.getOrganizations();
        }

    }

    @Override
    public Set<Organization> getOrganizationsByScope(Long scopeId) {
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
            Session session = closeableSession.getSession();
            Scope scope = (Scope) session.get(Membership.class, scopeId);

            return  scope.getOrganizations();
        }
    }

    @Override
    public Set<Organization> getOrganizationsByPhase(Long phaseId) {
        try (CloseableSession closeableSession = new CloseableSession(HibernateUtil.getSessionFactory().openSession())){
            Session session = closeableSession.getSession();
            Phase phase = (Phase) session.get(Phase.class, phaseId);

            return  phase.getOrganizations();
        }
    }



}
