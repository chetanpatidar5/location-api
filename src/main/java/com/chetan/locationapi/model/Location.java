package com.chetan.locationapi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "location")
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Name is required")
    private String name;
    private double lat;
    private double lng;
    @Pattern(regexp = "premium|standard", message = "Type must be either 'premium' or 'standard'")
    private String type;

}
