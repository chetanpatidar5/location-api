
package com.chetan.locationapi.service;

import com.chetan.locationapi.model.Location;

import java.util.List;


public interface LocationService {

    Location createLocation(Location location);

    List<Location> findAllLocation();

    List<Location> findAllLocationsByTypeWithPremiumOrStandard(String type, int limit);

    List<Location> findAllLocationsByPremium( int limit);

    public List<Location> findLocationsByLatAndLng(String type, Double lat1, Double lat2, Double lng1, Double lng2, int limit);

}










