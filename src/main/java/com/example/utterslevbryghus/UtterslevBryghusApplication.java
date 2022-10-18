package com.example.utterslevbryghus;

import com.example.utterslevbryghus.Beer.Model.Beer;
import com.example.utterslevbryghus.Beer.Model.BeerRepository;

import com.example.utterslevbryghus.Beer.Model.BeerType;


import com.example.utterslevbryghus.Customer.Model.Customer;
import com.example.utterslevbryghus.Customer.Repository.CustomerRepository;
import com.example.utterslevbryghus.Reservation.Model.Reservation;
import com.example.utterslevbryghus.Reservation.Repository.ReservationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class UtterslevBryghusApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(UtterslevBryghusApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(BeerRepository beerRepository,
                                        CustomerRepository customerRepository,
                                        ReservationRepository reservationRepository
                                        )
    {
        return (args) -> {

            final List<Beer> beers = new ArrayList<>();
            beers.add(new Beer("god øl", 33, 1000, 4.6, BeerType.IPA));
            beers.add(new Beer("zando øl", 66, 400, 9, BeerType.DARK));
            beers.add(new Beer("hejøl", 99, 300, 3, BeerType.IPA));
            beers.add(new Beer("sommerøl", 15, 20, 10, BeerType.PILSNER));
            beerRepository.saveAll(beers);

            final List<Customer> customers = new ArrayList<>();
            customers.add(new Customer("john", "zando"));
            customers.add(new Customer("john", "zito"));
            customers.add(new Customer("john", "benz"));
            customers.add(new Customer("john", "riise"));
            customerRepository.saveAll(customers);

            final List<Customer> reservationCustomers = Arrays.asList(customers.get(0), customers.get(1));


            final List<Reservation> reservations = new ArrayList<>();
            reservations.add(new Reservation(new Date(), new Date(), customers, beers.get(1)));
            reservations.add(new Reservation(new Date(), new Date(), customers, beers.get(1)));
            reservations.add(new Reservation(new Date(), new Date(), customers, beers.get(2)));
            reservations.add(new Reservation(new Date(), new Date(), customers, beers.get(3)));
            reservations.add(new Reservation(new Date(), new Date(), customers, beers.get(2)));
            reservations.add(new Reservation(new Date(), new Date(), customers, beers.get(2)));
            reservations.add(new Reservation(new Date(), new Date(), customers, beers.get(2)));
            reservationRepository.saveAll(reservations);

            reservationCustomers.forEach(reservationCustomer -> reservationCustomer.getReservationList().add(reservations.get(0)));
            customerRepository.saveAll(reservationCustomers);


        };
    }
}
