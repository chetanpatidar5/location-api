/*
package com.chetan.locationapi.service;

import com.chetan.locationapi.model.Location;
import com.chetan.locationapi.repository.LocationRepository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LocationService {

    Location createLocation(Location location);

    List<Location> getAllLocation();



    @Query("SELECT l FROM Location l " +
            "WHERE (:type IS NULL OR l.type = :type) " +
            "AND (l.latitude BETWEEN :lat1 AND :lat2) " +
            "AND (l.longitude BETWEEN :lng1 AND :lng2) " +
            "ORDER BY l.type DESC")
    List<Location> findLocationsByTypeAndCoordinates(@Param("type") String type,
                                                     @Param("lat1") double lat1,
                                                     @Param("lat2") double lat2,
                                                     @Param("lng1") double lng1,
                                                     @Param("lng2") double lng2,
                                                     Pageable pageable);
 }







*/
