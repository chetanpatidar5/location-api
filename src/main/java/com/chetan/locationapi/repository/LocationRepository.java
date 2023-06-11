package com.chetan.locationapi.repository;

import com.chetan.locationapi.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LocationRepository extends JpaRepository<Location, Long> {


    @Query(value = "SELECT * FROM location ORDER BY CASE WHEN type = 'premium' THEN 0 ELSE 1 END, type " + "LIMIT :limit", nativeQuery = true)
    List<Location> findAllLocationsByTypeWithPremiumFirst(int limit);

    @Query(value = "SELECT * FROM location WHERE type = ?1 ORDER BY type DESC LIMIT ?2", nativeQuery = true)
    List<Location> findAllLocationsByTypeWithPremiumOrStandard(String type, int limit);

    @Query(value = "SELECT * FROM location " +
            "WHERE type = :type " +
            "AND lat >= :lat1 AND lng >= :lng1 " +
            "AND lat <= :lat2 AND lng <= :lng2 " +
            "ORDER BY CASE WHEN type = 'premium' THEN 0 ELSE 1 END, type " +
            "LIMIT :limit", nativeQuery = true)
    List<Location> findLocationsForLatAndLng(String type, double lat1, double lat2, double lng1, double lng2, int limit);
}




