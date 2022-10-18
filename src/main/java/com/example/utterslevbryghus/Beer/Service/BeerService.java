package com.example.utterslevbryghus.Beer.Service;
import com.example.utterslevbryghus.Beer.Dto.BeerDto;
import com.example.utterslevbryghus.Beer.Model.Beer;
import com.example.utterslevbryghus.Beer.Model.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerDtoMapper modelMapper;




    public BeerService(BeerRepository beerRepository, BeerDtoMapper modelMapper) {
        this.beerRepository = beerRepository;
       this.modelMapper = modelMapper;


    }



    public BeerDto addBeer(BeerDto beerDto){
        Beer beer = modelMapper.DtoToBeer(beerDto);
        return modelMapper.BeerToDto(beerRepository.save(beer));
    }

    public List<BeerDto> findAllBeers(){
        return beerRepository
                .findAll()
                .stream()
                .map(modelMapper::BeerToDto)
                .collect(Collectors.toList());
    }


    public BeerDto getBeerId(Long id){
        Beer beer = beerRepository.findById(id).orElseThrow(() -> new IllegalStateException("no beer with that" + id)); //lave exception klasse her.
        return modelMapper.BeerToDto(beer);
    }

    public BeerDto getBeerByName(String name){
        return modelMapper.BeerToDto(beerRepository.findBeerByName(name));
    }

    public void deleteBeer(Long id){
        boolean exists = beerRepository.existsById(id);
        if (!exists){
        throw new IllegalStateException("does not exists" + id);
        }
        beerRepository.deleteById(id);
    }

    public BeerDto update(Long id, BeerDto beerDto){
        Beer beer = beerRepository.findById(id).orElse(null);
        assert beer != null;
        beer.setId(beerDto.getId());
        beer.setName(beerDto.getName());
        beerRepository.save(beer);
        return modelMapper.BeerToDto(beer);
        }
}
