package cheikh.beidja.reservationservice.dto;

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
}
