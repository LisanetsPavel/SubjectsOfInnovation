package com.dao;

import com.entity.Location;
import com.entity.Membership;
import com.entity.Phase;
import org.springframework.stereotype.Repository;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public interface PhaseDao {

    void setPhase(Phase phase);

    Phase getPhaseById(Long phaseId);

    void deletePhase(Phase phase);

    void updatePhase(Phase phase);

}
