package com.dao.implement;

import com.dao.PhaseDao;
import com.entity.Phase;
import org.springframework.stereotype.Repository;


/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public class PhaseDaoImpl extends GenericDao implements PhaseDao {
    @Override
    public void setPhase(Phase phase) {
        set(phase);
    }

    @Override
    public Phase getPhaseById(Long phaseId) {
        return (Phase) get(phaseId, Phase.class);
    }

    @Override
    public void deletePhase(Phase phase) {
        delete(phase);
    }

    @Override
    public void updatePhase(Phase phase) {
        update(phase);
    }

    @Override
    public Phase getPhaseByName(String name) {
        return (Phase) getByName(name, Phase.class);
    }
}
