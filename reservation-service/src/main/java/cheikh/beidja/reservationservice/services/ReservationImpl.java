package cheikh.beidja.reservationservice.services;

import cheikh.beidja.reservationservice.dto.PersonResponseDTO;
import cheikh.beidja.reservationservice.dto.ReservationRequestDTO;
import cheikh.beidja.reservationservice.dto.ReservationResponseDTO;
import cheikh.beidja.reservationservice.entities.Person;
import cheikh.beidja.reservationservice.entities.Reservation;
import cheikh.beidja.reservationservice.mapper.PersonMapper;
import cheikh.beidja.reservationservice.mapper.ReservationMapper;
import cheikh.beidja.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservationImpl implements ReservationService{
    private ReservationMapper reservationMapper;
    private ReservationRepository reservationRepository;

    public ReservationImpl(ReservationMapper reservationMapper, ReservationRepository reservationRepository) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ReservationResponseDTO addReservation(ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = reservationMapper.toReservation(reservationRequestDTO);
        Reservation reservationsaved = reservationRepository.save(reservation);
        ReservationResponseDTO reservationResponseDTO = reservationMapper.fromReservation(reservationsaved);
        return reservationResponseDTO;
    }

    @Override
    public ReservationResponseDTO getReservationById(Long reservationId) {
        Reservation reservation=reservationRepository.findById(reservationId).orElseThrow(() -> new RuntimeException("reservation not found with id: " + reservationId));
        ReservationResponseDTO reservationResponseDTO=reservationMapper.fromReservation(reservation);
        return reservationResponseDTO;
    }

    @Override
    public List<ReservationResponseDTO> getAllReservations() {
        List<Reservation> allReservation = reservationRepository.findAll();
        return allReservation.stream()
                .map(reservationMapper::fromReservation)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationResponseDTO updateReservation(Long id, ReservationRequestDTO reservationRequestDTO) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
        existingReservation.setNom(reservationRequestDTO.getNom());
        existingReservation.setContext(reservationRequestDTO.getContext());
        Reservation updatedReservation = reservationRepository.save(existingReservation);
        ReservationResponseDTO reservationResponseDTO = reservationMapper.fromReservation(updatedReservation);
        return reservationResponseDTO;
    }
}
