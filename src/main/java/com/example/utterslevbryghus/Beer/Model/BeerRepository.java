package com.example.utterslevbryghus.Beer.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer,Long> {
    Beer findBeerByName(String name);
}
