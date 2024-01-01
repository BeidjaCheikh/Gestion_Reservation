package cheikh.beidja.reservationservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "fullReservation",types = Reservation.class)
public interface ReservationProjection {
    Long getId();
    String getName();
    String getContext();
    Date getDate();
    int getDuration();
    Long getResourceId();

}
