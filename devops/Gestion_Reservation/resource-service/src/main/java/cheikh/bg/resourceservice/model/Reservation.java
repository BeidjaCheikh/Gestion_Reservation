package cheikh.bg.resourceservice.model;
import lombok.Data;
import java.util.Date;
@Data
public class Reservation {
    private Long id;
    private String nom;
    private String context;
    private Date date;
    private int duration;

}
