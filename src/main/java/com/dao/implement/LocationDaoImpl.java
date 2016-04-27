package com.dao.implement;

import com.dao.LocationDao;
import com.entity.Location;
import com.entity.Organization;
import com.util.CloseableSession;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public class LocationDaoImpl extends GenericDao implements LocationDao {
    @Override
    public void setLocation(Location location) {
        set(location);
    }

    @Override
    public Location getLocationById(Long locationId) {
       return (Location) get(locationId, Location.class);
    }

    @Override
    public void deleteLocation(Location location) {
       delete(location);
    }

    @Override
    public void updateLocation(Location location) {
        update(location);
    }

    @Override
    public Location getLocationByName(String name) {
        return (Location) getByName(name, Location.class);
    }
}
