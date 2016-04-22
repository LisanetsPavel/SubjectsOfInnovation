package com.dao;

import com.entity.Location;
import com.entity.Membership;
import org.springframework.stereotype.Repository;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public interface MembershipDao {

    void setMembership(Membership membership);

    Membership getMembershipById(Long membershipId);

    void deleteMembership(Membership membership);

    void updateMembership(Membership membership);

}
