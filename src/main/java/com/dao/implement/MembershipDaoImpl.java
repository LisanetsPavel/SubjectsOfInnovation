package com.dao.implement;

import com.dao.MembershipDao;
import com.entity.Location;
import com.entity.Membership;
import com.entity.Organization;
import com.util.CloseableSession;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

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
}
