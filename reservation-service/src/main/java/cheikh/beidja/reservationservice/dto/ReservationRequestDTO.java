package cheikh.beidja.reservationservice.dto;

import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ReservationRequestDTO {
    private String nom;
    private String context;
    private int duration;
}
