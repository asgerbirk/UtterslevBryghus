package com.example.utterslevbryghus.Customer.Service;

import com.example.utterslevbryghus.Customer.Dto.CustomerDto;
import com.example.utterslevbryghus.Customer.Model.Customer;
import com.example.utterslevbryghus.Customer.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public CustomerDto addCustomer(CustomerDto customerDto){
        Customer customer = modelMapper.DtoToCustomer(customerDto);
        return modelMapper.CustomerToDto(customerRepository.save(customer));
    }

    public List<CustomerDto> findAllCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(modelMapper::CustomerToDto)
                .collect(Collectors.toList());
    }

    public void deleteCustomer(Long id){
        boolean exists = customerRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("does not exists" + id);
        }
        customerRepository.deleteById(id);
    }



}
