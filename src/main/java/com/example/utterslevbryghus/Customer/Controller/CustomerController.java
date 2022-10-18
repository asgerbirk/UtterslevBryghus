package com.example.utterslevbryghus.Customer.Controller;


import com.example.utterslevbryghus.Beer.Dto.BeerDto;
import com.example.utterslevbryghus.Customer.Dto.CustomerDto;
import com.example.utterslevbryghus.Customer.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok().body(customerService.findAllCustomers());
    }



    @PostMapping
    public ResponseEntity<CustomerDto> createBeer(@Valid @RequestBody CustomerDto customerDto){
        return ResponseEntity.ok().body(customerService.addCustomer(customerDto));
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> put(@PathVariable("id") Long id, @Valid @RequestBody CustomerDto customerDto){
        return ResponseEntity.ok().body(customerService.update(id,customerDto));
    }

     */
/*
    @PatchMapping("/{id}")
    public ResponseEntity<Beer> patch(@PathVariable("id") Long id, @Valid @RequestBody Beer beer){
        return ResponseEntity.ok().body(beerService.update(id,beer));
    }

 */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBeer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

}
