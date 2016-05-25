package com.dao.implement;

import com.dao.MembershipDao;
import com.entity.Membership;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public class MembershipDaoImpl extends GenericDao implements MembershipDao {
    @Override
    public void setMembership(Membership membership) {
        set(membership);
    }

    @Override
    public Membership getMembershipById(Long membershipId) {
        return (Membership) get(membershipId, Membership.class);
    }

    @Override
    public void deleteMembership(Membership membership) {
        delete(membership);
    }

    @Override
    public void updateMembership(Membership membership) {
        update(membership);
    }

    @Override
    public Membership getMembershipByName(String name){

        return (Membership)  getByName(name, Membership.class);
    }

    @Override
    public List<Membership> getAllMemberships() {
        return getAll(Membership.class);
    }
}
