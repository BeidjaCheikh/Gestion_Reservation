package cheikh.bg.resourceservice;

import cheikh.bg.resourceservice.entities.Resource;
import cheikh.bg.resourceservice.repository.ResourceRepository;
import cheikh.bg.resourceservice.enums.TypeResource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ResourceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner initializeResources(ResourceRepository resourceRepository) {
        return args -> {
            // Insert some resources
            resourceRepository.saveAll(List.of(
                    Resource.builder().name("Ordinateur Portable").typeResource(TypeResource.MATERIEL_INFO).build(),
                    Resource.builder().name("Projecteur").typeResource(TypeResource.MATERIEL_AUDIO_VISUEL).build(),
                    Resource.builder().name("Microphone").typeResource(TypeResource.MATERIEL_INFO).build(),
                    Resource.builder().name("Tablette").typeResource(TypeResource.MATERIEL_INFO).build(),
                    Resource.builder().name("Enceinte").typeResource(TypeResource.MATERIEL_AUDIO_VISUEL).build(),
                    Resource.builder().name("Appareil Photo").typeResource(TypeResource.MATERIEL_AUDIO_VISUEL).build()
            ));

            // Display all resources (optional)
            resourceRepository.findAll().forEach(System.out::println);
        };
    }


}
