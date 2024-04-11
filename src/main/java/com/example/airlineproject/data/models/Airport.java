package com.example.airlineproject.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Airport {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String code;
    private  String name;
    private  String location;
//    private  String departureCode;
//    private  String departureName;
//    private  String departureLocation;


}
