package com.service;

import com.dao.PhaseDao;
import com.entity.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pc8 on 28.04.16.
 */
@Service
public class PhaseService {

    @Autowired
    PhaseDao phaseDao;

    public void setPhase(String name){
        Phase phase = new Phase();
        phase.setName(name);
        phaseDao.setPhase(phase);

    }


}