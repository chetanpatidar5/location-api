package com.chetan.locationapi.service;

import com.chetan.locationapi.model.Location;
import com.chetan.locationapi.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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

    @Override
    public List<Location> findAllLocationsByTypeWithPremiumOrStandard(String type, int limit) {
        return locationRepository.findAllLocationsByTypeWithPremiumOrStandard(type,limit);
    }

    public List<Location> findAllLocationsByPremium(int limit) {
        List<Location> listOfLocations = locationRepository.findAllLocationsByTypeWithPremiumFirst(limit);
        log.debug("inside the findAllLocationsByType");
        return listOfLocations.stream().filter(l -> l.getType().equals("premium")).collect(Collectors.toList());
    }



    public List<Location> findLocationsByLatAndLng(String type, Double lat1, Double lat2, Double lng1, Double lng2, int limit) {
        if (type != null && !type.isEmpty() && lat1 != null && lng1 != null && lat2 != null && lng2 != null) {
            log.debug("inside the search location");
            return locationRepository.findLocationsForLatAndLng(type, lat1, lat2, lng1, lng2, limit);
        } else if (type != null && !type.isEmpty()) {
            log.debug("inside the search with Locations By Type");
            return this.findAllLocationsByTypeWithPremiumOrStandard(type, limit);
        } else {
            log.debug("inside the search where results should be premium first");
            return this.findAllLocationsByPremium(limit);
        }
    }
}