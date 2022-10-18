package com.example.utterslevbryghus.Beer.Model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BEER")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int size;
    private int price;
    private double alcoholProcent;
    @Enumerated(EnumType.STRING)
    private BeerType beerType;



    public Beer(String name, int size, int price, double alcoholProcent, BeerType beerType) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.alcoholProcent = alcoholProcent;
        this.beerType = beerType;
    }
}
