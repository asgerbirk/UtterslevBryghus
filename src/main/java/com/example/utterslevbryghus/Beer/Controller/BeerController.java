package com.example.utterslevbryghus.Beer.Controller;
import com.example.utterslevbryghus.Beer.Dto.BeerDto;
import com.example.utterslevbryghus.Beer.Service.BeerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/beers")
public class BeerController {

    private final BeerService beerService;

    

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    public ResponseEntity<List<BeerDto>> getAllBeers(){
        return ResponseEntity.ok().body(beerService.findAllBeers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeerDto> findById(@PathVariable("id")Long id){
        return ResponseEntity.ok().body(beerService.getBeerId(id));
    }


    @PostMapping
    public ResponseEntity<BeerDto> createBeer(@Valid @RequestBody BeerDto beerDto){
        return ResponseEntity.ok().body(beerService.addBeer(beerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeerDto> put(@PathVariable("id") Long id, @Valid @RequestBody BeerDto beerDto){
        return ResponseEntity.ok().body(beerService.update(id,beerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBeer(@PathVariable("id") Long id){
        beerService.deleteBeer(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
}
