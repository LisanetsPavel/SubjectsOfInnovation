package com.dao.implement;

import com.dao.OrganizationDao;
import com.entity.*;
import com.exception.DaoException;
import com.util.CloseableSession;
import com.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by pc8 on 15.04.16.
 */
@Repository
public class OrganizationDaoImpl extends GenericDao implements OrganizationDao {

    private static final Logger logger = Logger.getLogger(OrganizationDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setOrganization(Organization organization) {
         set(organization);
    }

    public Organization getOrganizationById(Long organizationId) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())){

            Session session = closeableSession.getSession();
            return  (Organization) session.get(Organization.class, organizationId);

        }catch (Exception e){
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())){
            Session session = closeableSession.getSession();
            return  (List<Organization>) session.createCriteria(Organization.class).list();

        }catch (Exception e){
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public List<Organization> getAgreedOrganizations() {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())){
          Session session = closeableSession.getSession();
          return  (List<Organization>) session.createCriteria(Organization.class).add(Restrictions.eq("agreed", true)).list();
      }catch (Exception e){
          logger.error(e);
          throw new DaoException(e);
      }
    }

    @Override
    public List<Organization> getDisagreedOrganizations() {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())){
            Session session = closeableSession.getSession();
            return  (List<Organization>) session.createCriteria(Organization.class).add(Restrictions.eq("agreed", false)).list();
        }catch (Exception e){
            logger.error(e);
            throw new DaoException(e);
        }
    }

    public Set<Organization> getOrganizationsBySubject(Long subjectId) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())){
            Session session = closeableSession.getSession();
            Subject subject = (Subject) session.get(Subject.class, subjectId);

            return  subject.getOrganizations();
        }catch (Exception e){
            logger.error(e);
            throw new DaoException(e);
        }
    }

    public Set<Organization> getOrganizationsByLocation(Long locationId) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())){
            Session session = closeableSession.getSession();
            Location location = (Location) session.get(Location.class, locationId);

            return  location.getOrganizations();
        }catch (Exception e){
            logger.error(e);
            throw new DaoException(e);
        }
    }

    public Set<Organization> getOrganizationsByMembership(Long membershipId) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())){
            Session session = closeableSession.getSession();
            Membership member = (Membership) session.get(Membership.class, membershipId);

            return  member.getOrganizations();
        }catch (Exception e){
            logger.error(e);
            throw new DaoException(e);
        }

    }

    @Override
    public Set<Organization> getOrganizationsByScope(Long scopeId) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())){
            Session session = closeableSession.getSession();
            Scope scope = (Scope) session.get(Membership.class, scopeId);

            return  scope.getOrganizations();
        }catch (Exception e){
            logger.error(e);
            throw new DaoException(e);
        }
    }

    @Override
    public Set<Organization> getOrganizationsByPhase(Long phaseId) {
        try (CloseableSession closeableSession = new CloseableSession(sessionFactory.openSession())){
            Session session = closeableSession.getSession();
            Phase phase = (Phase) session.get(Phase.class, phaseId);

            return  phase.getOrganizations();
        }catch (Exception e){
            logger.error(e);
            throw new DaoException(e);
        }
    }



}
