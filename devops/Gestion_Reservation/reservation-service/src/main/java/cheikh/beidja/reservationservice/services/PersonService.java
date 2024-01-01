package cheikh.beidja.reservationservice.services;

import cheikh.beidja.reservationservice.dto.PersonRequestDTO;
import cheikh.beidja.reservationservice.dto.PersonResponseDTO;
import cheikh.beidja.reservationservice.dto.ReservationResponseDTO;

import java.util.List;

public interface PersonService {
    PersonResponseDTO addPerson(PersonRequestDTO personRequestDTO);
    PersonResponseDTO getPersonById(Long personId);
    List<PersonResponseDTO> getAllPerson();
    PersonResponseDTO updatePerson(Long id,PersonRequestDTO personRequestDTO );
    List<ReservationResponseDTO> resrvationByPersonId(Long id);
}
