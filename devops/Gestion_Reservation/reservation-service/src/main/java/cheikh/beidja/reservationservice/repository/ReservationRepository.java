package cheikh.beidja.reservationservice.repository;

import cheikh.beidja.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RestResource
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findByPersonId(Long id);
}
