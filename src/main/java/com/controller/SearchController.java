package com.controller;

import com.entity.Subject;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pc8 on 17.05.16.
 */

@RestController
public class SearchController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private ScopeService scopeService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private MembershipService membershipService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private PhaseService phaseService;


    @RequestMapping(value = "/getAgreedOrgs", method = RequestMethod.GET)
    public String getAgreedOrg() {
        return organizationService.getAgreedOrganizations();
    }

    @RequestMapping(value = "/getDisagreedOrgs", method = RequestMethod.GET)
    public String getDisAgreedOrg() {
        return organizationService.getDisagreedOrganizations();
    }

    @RequestMapping(value = "/getOrgs", method = RequestMethod.GET)
    public String getAllOrg() {
        return organizationService.getAllOrganizations();
    }

    @RequestMapping(value = "/getScopes", method = RequestMethod.GET)
    public String getAllScopes() {
        return scopeService.getAllScopes();
    }

    @RequestMapping(value = "/getPhases", method = RequestMethod.GET)
    public String getAllPhases() {
        return phaseService.getAllPhases();
    }

    @RequestMapping(value = "/getSubjects", method = RequestMethod.GET)
    public String getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @RequestMapping(value = "/getLocations", method = RequestMethod.GET)
    public String getAllLOcations() {
        return locationService.getAllLocations();
    }

    @RequestMapping(value = "/getMemberships", method = RequestMethod.GET)
    public String getAllMemberships() {
        return membershipService.getAllMemberships();
    }
}
