package com.chetan.locationapi.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "location")
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double lat;
    private double lng;
    private String type;

}
