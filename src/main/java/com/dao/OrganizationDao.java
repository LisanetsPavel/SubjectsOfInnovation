package com.dao;

import com.entity.Membership;
import com.entity.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by pc8 on 15.04.16.
 */
@Repository
public interface OrganizationDao {

     void setOrganization(Organization organization);

     void updateOrganization(Organization organization);

     Organization getOrganizationById(Long organizationId);

     List<Organization> getAllOrganizations();

     List<Organization> getAgreedOrganizations();

     List<Organization> getDisagreedOrganizations();

     Set<Organization> getOrganizationsBySubject(Long subjectId);

     Set<Organization> getOrganizationsByLocation(Long locationId);

     Set<Organization> getOrganizationsByMembership(Long membershipId);

     Set<Organization> getOrganizationsByScope(Long scopeId);

     Set<Organization> getOrganizationsByPhase(Long phaseId);



}
