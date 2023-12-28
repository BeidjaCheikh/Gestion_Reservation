package cheikh.beidja.reservationservice;

import cheikh.beidja.reservationservice.dto.ResourceResponseDTO;
import cheikh.beidja.reservationservice.entities.Person;
import cheikh.beidja.reservationservice.entities.Reservation;
import cheikh.beidja.reservationservice.model.Resource;
import cheikh.beidja.reservationservice.repository.PersonRepository;
import cheikh.beidja.reservationservice.repository.ReservationRepository;
import cheikh.beidja.reservationservice.services.ResourceRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ResourceRestClientService resourceRestClientService,
                            ReservationRepository reservationRepository,
                            PersonRepository personRepository) {
        return args -> {
            List<ResourceResponseDTO> resourceResponseDTOS = resourceRestClientService.allResources();
            Random random = new Random();

            // Lists
            List<String> predefinedNames = Arrays.asList("Lemine","John Doe", "Jane Doe", "Alice Smith");
            List<String> predefinedFunctions = Arrays.asList("Manager", "Developer", "Designer", "Sales Representative");
            List<String> predefinedReservationNames = Arrays.asList("Meeting", "Conference", "Workshop", "Training");
            List<String> predefinedContexts = Arrays.asList("Education", "Technology", "Healthcare", "Entertainment");

            for (int j = 0; j < 4; j++) {
                // Utilisation des listes pré-définies
                String predefinedName = predefinedNames.get(j);
                String predefinedFunction = predefinedFunctions.get(j);
                String predefinedEmail = generatePredefinedEmail(predefinedName);

                Person person = Person.builder()
                        .nom(predefinedName)
                        .email(predefinedEmail)
                        .function(predefinedFunction)
                        .build();
                       personRepository.save(person);
            }
            List<Person> personList = personRepository.findAll();
            for (Person p : personList) {
                for (int i = 0; i < 4; i++) {
                    ResourceResponseDTO randomResource = resourceResponseDTOS.get(random.nextInt(resourceResponseDTOS.size()));
                    Reservation reservation = Reservation.builder()
                            .resourceId(randomResource.getId())
                            .date(new Date())
                            .nom(predefinedReservationNames.get(i))
                            .context(predefinedContexts.get(i))
                            .duration(random.nextInt(10) + 1)
                            .person(p)
                            .build();
                    reservationRepository.save(reservation);
                }
            }

        };
    }

    private String generatePredefinedEmail(String name) {
        // Générer une adresse e-mail fictive basée sur le nom
        String[] nameParts = name.split(" ");
        String firstName = nameParts[0].toLowerCase();
        String lastName = nameParts.length > 1 ? nameParts[1].toLowerCase() : "";
        return firstName + "." + lastName + "@gmail.com";
    }
}
