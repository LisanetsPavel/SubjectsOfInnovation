package com.dao;

import com.entity.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc8 on 18.04.16.
 */
@Repository
public interface LocationDao {

    void setLocation(Location location);

    Location getLocationById(Long locationId);

    void deleteLocation(Location location);

    void updateLocation(Location location);

    Location getLocationByName(String name);

    List<Location> getAllLocations();
}
