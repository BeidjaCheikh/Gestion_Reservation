package cheikh.beidja.reservationservice.mapper;

import cheikh.beidja.reservationservice.dto.PersonRequestDTO;
import cheikh.beidja.reservationservice.dto.PersonResponseDTO;
import cheikh.beidja.reservationservice.entities.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public PersonResponseDTO fromPerson(Person person){
        PersonResponseDTO personResponseDTO =new PersonResponseDTO();
        BeanUtils.copyProperties(person,personResponseDTO);
        return personResponseDTO;
    }
    public Person toPerson(PersonRequestDTO personRequestDTO) {
        Person person = new Person();
        BeanUtils.copyProperties(personRequestDTO, person);
        return person;
    }
}
