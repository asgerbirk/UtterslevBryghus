package com.example.utterslevbryghus.Reservation.Repository;

import com.example.utterslevbryghus.Reservation.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
