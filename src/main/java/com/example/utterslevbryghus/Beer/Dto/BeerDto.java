package com.example.utterslevbryghus.Beer.Dto;
import com.example.utterslevbryghus.Beer.Model.BeerType;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeerDto {


    private Long id;
    private String name;
    private int size;
    private int price;
    private double alcoholProcent;
    private BeerType beerType;

}
