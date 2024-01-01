package cheikh.beidja.reservationservice.dto;

import cheikh.beidja.reservationservice.entities.Person;
import cheikh.beidja.reservationservice.model.Resource;
import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReservationResponseDTO {
    private Long id;
    private String nom;
    private String context;
    private Date date;
    private int duration;
    private Person person;
    private Resource resource;
    private Long resourceId;
}
