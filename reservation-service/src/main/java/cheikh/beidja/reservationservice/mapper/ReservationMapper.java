package cheikh.beidja.reservationservice.mapper;

import cheikh.beidja.reservationservice.dto.PersonRequestDTO;
import cheikh.beidja.reservationservice.dto.PersonResponseDTO;
import cheikh.beidja.reservationservice.dto.ReservationRequestDTO;
import cheikh.beidja.reservationservice.dto.ReservationResponseDTO;
import cheikh.beidja.reservationservice.entities.Person;
import cheikh.beidja.reservationservice.entities.Reservation;
import cheikh.beidja.reservationservice.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReservationMapper {
    private final PersonRepository personRepository;
    public ReservationResponseDTO fromReservation(Reservation reservation){
        ReservationResponseDTO reservationResponseDTO =new ReservationResponseDTO();
        BeanUtils.copyProperties(reservation,reservationResponseDTO);
        return reservationResponseDTO;
    }
    public Reservation toReservation(ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationRequestDTO, reservation);
        return reservation;
    }

}
