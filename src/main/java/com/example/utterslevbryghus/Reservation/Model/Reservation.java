package com.example.utterslevbryghus.Reservation.Model;

import com.example.utterslevbryghus.Beer.Model.Beer;
import com.example.utterslevbryghus.Customer.Model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Date startDate;

    Date endDate;

    @ManyToMany(mappedBy = "reservationList")
    List<Customer> customers = new ArrayList<>();

    @ManyToOne
    Beer beer;

    public Reservation(Date startDate, Date endDate, List<Customer> customers, Beer beer) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customers = customers;
        this.beer = beer;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", customers=" + customers +
                ", beer=" + beer +
                '}';
    }
}
