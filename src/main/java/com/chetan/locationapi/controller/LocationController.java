package com.chetan.locationapi.controller;


import com.chetan.locationapi.model.Location;
import com.chetan.locationapi.service.LocationServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
public class LocationController {
    @Autowired
    private LocationServiceImpl locationService;


    @PostMapping("/location")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {

        Location locations = locationService.createLocation(location);
        return new ResponseEntity<>(locations, HttpStatus.CREATED);
    }

    @GetMapping("/getAllLocation")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> getAllLocations = locationService.getAllLocation();
        return new ResponseEntity<>(getAllLocations, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Location>> searchLocationsByType(@RequestParam(required = false) String type,
                                                          @RequestParam(defaultValue = "10") int limit
    ) {
        List<Location> locations = locationService.searchLocationsByType(type, limit);
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> searchLocationsAndLat(
            @RequestParam(required = false) String type,
            @RequestParam double lat1,
            @RequestParam double lat2,
            @RequestParam double lng1,
            @RequestParam double lng2,
            @RequestParam(defaultValue = "10") int limit
    ) {
        List<Location> locations = locationService.searchLocationsByTypeAndLat(type, lat1, lat2, lng1, lng2, limit);
        return new ResponseEntity<>(locations, HttpStatus.OK);

    }
}




