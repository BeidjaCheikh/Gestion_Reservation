package cheikh.beidja.reservationservice.services;

import cheikh.beidja.reservationservice.dto.PersonResponseDTO;
import cheikh.beidja.reservationservice.dto.ReservationRequestDTO;
import cheikh.beidja.reservationservice.dto.ReservationResponseDTO;
import cheikh.beidja.reservationservice.dto.ResourceResponseDTO;
import cheikh.beidja.reservationservice.entities.Person;
import cheikh.beidja.reservationservice.entities.Reservation;
import cheikh.beidja.reservationservice.mapper.PersonMapper;
import cheikh.beidja.reservationservice.mapper.ReservationMapper;
import cheikh.beidja.reservationservice.model.Resource;
import cheikh.beidja.reservationservice.repository.PersonRepository;
import cheikh.beidja.reservationservice.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ReservationImpl implements ReservationService{
    private ReservationMapper reservationMapper;
    private ReservationRepository reservationRepository;
    private ResourceRestClientService resourceRestClientService;
    private PersonRepository personRepository;



    @Override
    public ReservationResponseDTO addReservation(ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation=Reservation.builder().
                nom(reservationRequestDTO.getNom())
                .context(reservationRequestDTO.getContext())
                .duration(reservationRequestDTO.getDuration())
                .date(new Date())
                .resourceId(reservationRequestDTO.getResourceId())
                .person(personRepository.findById(reservationRequestDTO.getPersonId()).get())
                . build();
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
    public String getUserInfo() {
        // Retrieve the authentication object from the SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user is authenticated
        if (authentication.isAuthenticated() && authentication instanceof JwtAuthenticationToken) {
            // Extract JWT from JwtAuthenticationToken
            JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
            return jwtAuthenticationToken.getToken().getTokenValue();
        }

        // Return an error message if the user is not authenticated or the token is not a JWT
        return "Error retrieving user information";
    }

    @Override
    public List<Reservation> findByPersonId(Long id) {
        String jwtTokenValue=getUserInfo();
        List<Reservation> reservationList=reservationRepository.findByPersonId(id);
        for (Reservation r:reservationList) {
            RestClient restClient = RestClient.create("http://localhost:8881");
            ResourceResponseDTO responseDTOS = restClient.get()
                    .uri("/api/resources/"+r.getResourceId()+"?projection=fullResource")
                    .headers(httpHeaders -> httpHeaders.set(HttpHeaders.AUTHORIZATION, "Bearer "+jwtTokenValue))
                    .retrieve()
                    .body(new ParameterizedTypeReference<>(){});
            Resource resource=new Resource();
            resource.setId(responseDTOS.getId());
            resource.setName(responseDTOS.getName());
            resource.setTypeResource(responseDTOS.getTypeResource());
            r.setResource(resource);

        }
        return reservationList;
    }


}
