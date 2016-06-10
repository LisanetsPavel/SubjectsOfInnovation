package com.service;

import com.dao.MembershipDao;
import com.entity.Membership;
import com.util.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pc8 on 28.04.16.
 */
@Service
public class MembershipService {

    @Autowired
    MembershipDao membershipDao;

    public void setMembership(String name) {
        Membership membership = new Membership();
        membership.setName(name);
        membershipDao.setMembership(membership);

    }

    public void setMembership(Membership membership) {

        membershipDao.setMembership(membership);

    }

    public Membership getMembershipByName(String name) {
        return membershipDao.getMembershipByName(name);
    }

    public String getAllMemberships() {
        return JsonConverter.toJSON(membershipDao.getAllMemberships());
    }
}
