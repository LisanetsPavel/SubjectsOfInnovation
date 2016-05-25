package com.dao.implement;

import com.dao.ScopeDao;
import com.entity.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public class ScopeDaoImpl extends GenericDao implements ScopeDao {
    @Override
    public void setScope(Scope scope) {
        set(scope);
    }

    @Override
    public Scope getScopeById(Long scopeId) {
        return (Scope) get(scopeId, Scope.class);
    }

    @Override
    public void deleteScope(Scope scope) {
        delete(scope);
    }

    @Override
    public void updateScope(Scope scope) {
        update(scope);
    }

    @Override
    public Scope getScopeByName(String name) {
        return (Scope) getByName(name, Scope.class);
    }

    @Override
    public List<Scope> getAllScope() {
        return getAll(Scope.class);
    }


}
