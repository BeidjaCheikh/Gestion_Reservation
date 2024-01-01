package cheikh.beidja.reservationservice.web;

import cheikh.beidja.reservationservice.dto.PersonRequestDTO;
import cheikh.beidja.reservationservice.dto.PersonResponseDTO;
import cheikh.beidja.reservationservice.entities.Person;
import cheikh.beidja.reservationservice.model.Resource;
import cheikh.beidja.reservationservice.repository.PersonRepository;
import cheikh.beidja.reservationservice.services.PersonService;
import cheikh.beidja.reservationservice.services.ResourceRestClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PersonController {

    private PersonRepository personRepository;
    private PersonService personService;

    private final ResourceRestClientService resourceRestClientService;


    @GetMapping("/persons")
    public List<PersonResponseDTO> AllPersons(){
        return personService.getAllPerson();
    }
    @GetMapping("/persons/{id}")
    public PersonResponseDTO getPersonById(@PathVariable Long id) {

        return personService.getPersonById(id);
    }

    @PostMapping("/persons/create")
    public PersonResponseDTO createPerson(@RequestBody PersonRequestDTO personRequestDTO) {
        return personService.addPerson(personRequestDTO);
    }
    @PutMapping("/persons/update/{id}")
    public PersonResponseDTO updatePerson(@PathVariable Long id, @RequestBody PersonRequestDTO personRequestDTO) {
        return personService.updatePerson(id,personRequestDTO);
    }

    @DeleteMapping("/persons/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

}
