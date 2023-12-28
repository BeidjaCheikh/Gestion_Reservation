package cheikh.beidja.reservationservice.mapper;

import cheikh.beidja.reservationservice.dto.PersonRequestDTO;
import cheikh.beidja.reservationservice.dto.PersonResponseDTO;
import cheikh.beidja.reservationservice.dto.ReservationRequestDTO;
import cheikh.beidja.reservationservice.dto.ReservationResponseDTO;
import cheikh.beidja.reservationservice.entities.Person;
import cheikh.beidja.reservationservice.entities.Reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
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
