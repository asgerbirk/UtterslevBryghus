package com.example.utterslevbryghus.Customer.Service;

import com.example.utterslevbryghus.Beer.Dto.BeerDto;
import com.example.utterslevbryghus.Beer.Model.Beer;
import com.example.utterslevbryghus.Customer.Dto.CustomerDto;
import com.example.utterslevbryghus.Customer.Model.Customer;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class CustomerDtoMapper {
    private final ModelMapper modelMapper;

    public CustomerDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public CustomerDto CustomerToDto(Customer customer){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(customer,CustomerDto.class);
    }

    public Customer DtoToCustomer(CustomerDto customerDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(customerDto,Customer.class);
    }
}
