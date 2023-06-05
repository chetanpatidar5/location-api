package com.chetan.locationapi.service;

import com.chetan.locationapi.model.Location;
import com.chetan.locationapi.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> findAllLocation() {
        return locationRepository.findAll();
    }

    public List<Location> findAllLocationsByType(int limit) {
        List<Location> listOfLocations = locationRepository.findAllLocationsByTypeWithPremiumFirst(limit);
        return listOfLocations.stream().filter(l -> l.getType().equals("premium")).collect(Collectors.toList());
    }

    public List<Location> findLocationsByLatAndLng(String type, Double lat1, Double lat2, Double lng1, Double lng2, int limit) {
        if (type != null && !type.isEmpty() && lat1 != null && lng1 != null && lat2 != null && lng2 != null) {
            return locationRepository.findLocationsForLatAndLng(type, lat1, lat2, lng1, lng2, limit);
        } else {
            return this.findAllLocationsByType(limit);
        }
    }
}