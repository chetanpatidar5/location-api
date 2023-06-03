package com.chetan.locationapi.repository;

import com.chetan.locationapi.model.Location;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface LocationRepository extends JpaRepository<Location, Long> {


    @Query("SELECT l FROM Location l " +
            "WHERE (:type IS NULL OR l.type = :type) " +
            "ORDER BY l.type DESC")
    List<Location> findLocationsByType(@Param("type") String type, Pageable pageable);


    @Query("SELECT l FROM Location l " +
            "WHERE (:type IS NULL OR l.type = :type) " +
            "AND ((l.lat BETWEEN :lat1 AND :lat2) AND (l.lng BETWEEN :lng1 AND :lng2)) " +
            "ORDER BY CASE WHEN l.type = 'premium' THEN 0 ELSE 1 END, l.type ASC")
    List<Location> searchLocationsByTypeAndLatAndLng(@Param("type") String type,
                                                       @Param("lat1") double lat1,
                                                       @Param("lat2") double lat2,
                                                       @Param("lng1") double lng1,
                                                       @Param("lng2") double lng2,
                                                       Pageable pageable);
}



