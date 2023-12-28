package cheikh.beidja.reservationservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PersonRequestDTO {
    private String nom;
    private String email;
    private String function;
}
