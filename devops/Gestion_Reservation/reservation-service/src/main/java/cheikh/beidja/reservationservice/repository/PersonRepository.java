package cheikh.beidja.reservationservice.repository;

import cheikh.beidja.reservationservice.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RestController;

@RestResource
public interface PersonRepository extends JpaRepository<Person,Long> {
}
