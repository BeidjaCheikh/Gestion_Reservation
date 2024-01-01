package cheikh.beidja.reservationservice.dto;

import cheikh.beidja.reservationservice.entities.Reservation;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PersonResponseDTO {
    private Long id;
    private String nom;
    private String email;
    private String function;
    private List<Reservation> reservationList;
}
