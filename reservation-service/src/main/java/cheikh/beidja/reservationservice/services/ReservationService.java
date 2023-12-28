package cheikh.beidja.reservationservice.services;

import cheikh.beidja.reservationservice.dto.PersonRequestDTO;
import cheikh.beidja.reservationservice.dto.ReservationRequestDTO;
import cheikh.beidja.reservationservice.dto.ReservationResponseDTO;

import java.util.List;

public interface ReservationService {
    ReservationResponseDTO addReservation(ReservationRequestDTO reservationRequestDTO);
    ReservationResponseDTO getReservationById(Long reservationId);
    List<ReservationResponseDTO> getAllReservations();
    ReservationResponseDTO updateReservation(Long id,ReservationRequestDTO reservationRequestDTO );
}
