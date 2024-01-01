package cheikh.beidja.reservationservice.services;

import cheikh.beidja.reservationservice.dto.PersonRequestDTO;
import cheikh.beidja.reservationservice.dto.PersonResponseDTO;
import cheikh.beidja.reservationservice.dto.ReservationResponseDTO;
import cheikh.beidja.reservationservice.entities.Person;
import cheikh.beidja.reservationservice.entities.Reservation;
import cheikh.beidja.reservationservice.mapper.PersonMapper;
import cheikh.beidja.reservationservice.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonImpl implements PersonService{
    private PersonRepository personRepository;
    private PersonMapper personMapper;

    public PersonImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public PersonResponseDTO addPerson(PersonRequestDTO personRequestDTO) {
        Person person = personMapper.toPerson(personRequestDTO);
        Person personsaved = personRepository.save(person);
        PersonResponseDTO personResponseDTO = personMapper.fromPerson(personsaved);
        return personResponseDTO;
    }

    @Override
    public PersonResponseDTO getPersonById(Long personId) {
        Person person=personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Resource not found with id: " + personId));
        PersonResponseDTO personResponseDTO=personMapper.fromPerson(person);
        return personResponseDTO;
    }


    @Override
    public List<PersonResponseDTO> getAllPerson() {
        List<Person> allPerson = personRepository.findAll();
        return allPerson.stream()
                .map(personMapper::fromPerson)
                .collect(Collectors.toList());

    }

    @Override
    public PersonResponseDTO updatePerson(Long id, PersonRequestDTO personRequestDTO) {
        Person existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
        existingPerson.setNom(personRequestDTO.getNom());
        existingPerson.setEmail(personRequestDTO.getNom());
        Person updatedPerson = personRepository.save(existingPerson);
        PersonResponseDTO personResponseDTO = personMapper.fromPerson(updatedPerson);
        return personResponseDTO;
    }

    @Override
    public List<ReservationResponseDTO> resrvationByPersonId(Long id)
    {
        return null;
    }


}
