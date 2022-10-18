package com.example.utterslevbryghus.Beer.Service;

import com.example.utterslevbryghus.Beer.Dto.BeerDto;
import com.example.utterslevbryghus.Beer.Model.Beer;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class BeerDtoMapper {

    private final ModelMapper modelMapper;

    public BeerDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BeerDto BeerToDto(Beer beer){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(beer,BeerDto.class);
    }

    public Beer DtoToBeer(BeerDto beerDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(beerDto,Beer.class);
    }
}
