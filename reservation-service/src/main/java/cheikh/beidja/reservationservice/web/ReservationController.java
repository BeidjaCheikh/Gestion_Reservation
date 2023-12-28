package cheikh.beidja.reservationservice.web;

import cheikh.beidja.reservationservice.dto.*;
import cheikh.beidja.reservationservice.entities.Person;
import cheikh.beidja.reservationservice.entities.Reservation;
import cheikh.beidja.reservationservice.mapper.ReservationMapper;
import cheikh.beidja.reservationservice.model.Resource;
import cheikh.beidja.reservationservice.repository.ReservationRepository;
import cheikh.beidja.reservationservice.services.ReservationService;
import cheikh.beidja.reservationservice.services.ResourceRestClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ReservationController {
    private ResourceRestClientService resourceRestClientService;
    private ReservationMapper reservationMapper;

    private ReservationRepository reservationRepository;
    private ReservationService reservationService;


    public ReservationController(ResourceRestClientService resourceRestClientService, ReservationMapper reservationMapper, ReservationRepository reservationRepository, ReservationService reservationService) {
        this.resourceRestClientService = resourceRestClientService;
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<ReservationResponseDTO> allReservations() {

        return reservationService.getAllReservations();
    }
//    @GetMapping("/reservations/{id}")
//    public ReservationResponseDTO getReservationById(@PathVariable Long id) {
//        return reservationService.getReservationById(id);
//    }

    @PostMapping("/reservations")
    public ReservationResponseDTO createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        return reservationService.addReservation(reservationRequestDTO);
    }

    @PutMapping("/reservations/{id}")
    public ReservationResponseDTO updateReservation(@PathVariable Long id, @RequestBody ReservationRequestDTO reservationRequestDTO) {
        return reservationService.updateReservation(id, reservationRequestDTO);
    }


    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
    }

    @GetMapping("/fullReservation/{id}")
    public ReservationResponseDTO getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationRepository.findById(id).get();
        ResourceResponseDTO resourceResponseDTO = resourceRestClientService.resourceById(reservation.getResourceId());
        Resource resource=new Resource();
        resource.setName(resourceResponseDTO.getName());
        resource.setTypeResource(resourceResponseDTO.getTypeResource());
        //reservation.setResource(resourceResponseDTO);

        return null;
    }
}