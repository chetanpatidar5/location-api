package com.chetan.locationapi.service;

import com.chetan.locationapi.model.Location;
import com.chetan.locationapi.repository.LocationRepository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl {


    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }


    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }




    public List<Location> searchLocationsByType(String type, int limit) {
        Pageable pageable = PageRequest.of(0, limit, Sort.by("type").descending());
        return locationRepository.findLocationsByType(type, pageable);
    }

    public List<Location> searchLocationsByTypeAndLat(String type, double lat1, double lat2, double lng1, double lng2, int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return locationRepository.searchLocationsByTypeAndLatAndLng(type, lat1, lat2, lng1, lng2, pageable);
    }
}