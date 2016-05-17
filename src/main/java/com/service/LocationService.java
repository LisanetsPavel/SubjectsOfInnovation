package com.service;

import com.dao.LocationDao;
import com.entity.Location;
import com.util.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pc8 on 28.04.16.
 */
@Service
public class LocationService {

    @Autowired
    LocationDao locationDao;

    public void setLocation(String name){
        Location location = new Location();
        location.setName(name);
        locationDao.setLocation(location);
    }

    public void setLocation(Location location){
         locationDao.setLocation(location);
    }

    public Location getLocationByName(String name){
        return locationDao.getLocationByName(name);
    }

    public String getAllLocations(){
        return JsonConverter.toJSON(locationDao.getAllLocations());
    }
}
