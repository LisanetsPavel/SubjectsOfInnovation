package com;

import com.dao.OrganizationDao;
import com.dao.implement.OrganizationDaoImpl;
import com.dao.implement.SubjectDaoImpl;
import com.entity.Organization;

class Q {
    void mQ(int i) {
        System.out.print("mQ" + i);
    } }
class Quest6 extends Q {
    public void mQ(int i) {
        System.out.print("mQuest" + i);
    }

    public static void main(String args[]) {
        OrganizationDao dao = new OrganizationDaoImpl();
        Organization organization = new Organization();
        organization.setFullName("dfsaf");
        organization.setAgreed(true);

       dao.setOrganization(organization);



    } }