package com.dao;

import com.entity.Location;
import com.entity.Phase;
import com.entity.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public interface ScopeDao {

    void setScope(Scope scope);

    Scope getScopeById(Long scopeId);

    void deleteScope(Scope scope);

    void updateScope(Scope scope);

    Scope getScopeByName(String name);

    List<Scope> getAllScope();
}
