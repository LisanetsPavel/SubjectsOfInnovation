package com.dao;

import com.entity.Location;
import com.entity.Membership;
import com.entity.Phase;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public interface PhaseDao {

    void setPhase(Phase phase);

    Phase getPhaseById(Long phaseId);

    void deletePhase(Phase phase);

    void updatePhase(Phase phase);

    Phase getPhaseByName(String name);

    List<Phase> getAllPhase();
}
