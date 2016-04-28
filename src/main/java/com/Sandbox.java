package com;

import com.dao.OrganizationDao;
import com.dao.implement.OrganizationDaoImpl;
import com.service.OrganizationService;

/**
 * Created by pc9 on 27.04.16.
 */
public class Sandbox {

    public static void main(String[] args) {
        OrganizationDao organizationService = new OrganizationDaoImpl();

        System.out.println(organizationService.getAllOrganizations());
    }

}
