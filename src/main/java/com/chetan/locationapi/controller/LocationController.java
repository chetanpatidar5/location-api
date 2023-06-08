package com.chetan.locationapi.controller;


import com.chetan.locationapi.exception.ResourceNotFoundException;
import com.chetan.locationapi.model.Location;
import com.chetan.locationapi.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Location", description = "Location APIs")
@RequestMapping("/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @Operation(summary = "Create location API", description = "Create location REST API is used to save locations in a database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    @PostMapping("")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {

        Location locations = locationService.createLocation(location);
        return new ResponseEntity<>(locations, HttpStatus.CREATED);
    }

    @Operation(summary = "Get All Locations REST API", description = "Get All Locations REST API is used to get a all the locations from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping("/all")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> allLocations = locationService.findAllLocation();
        if (allLocations.isEmpty()) {
            throw new ResourceNotFoundException("No locations found.");
        }
        return new ResponseEntity<>(allLocations, HttpStatus.OK);
    }


    @Operation(summary = "search Locations REST API", description = "search Locations REST API is used to get  locations of latitude and longitude and type of locations from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping("/search")
    public ResponseEntity<List<Location>> searchLocations(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Double lat1,
            @RequestParam(required = false) Double lat2,
            @RequestParam(required = false) Double lng1,
            @RequestParam(required = false) Double lng2,
            @RequestParam(required = false, defaultValue = "10") int limit) {
        List<Location> locationsTypes = locationService.findLocationsByLatAndLng(type, lat1, lat2, lng1, lng2, limit);
        if (locationsTypes.isEmpty()) {
            throw new ResourceNotFoundException("No locations found.");
        }
        return new ResponseEntity<>(locationsTypes, HttpStatus.OK);
    }
}




