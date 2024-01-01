import {Component, OnInit} from '@angular/core';
import {ReservationService} from "../services/reservation.service";
import {Reservation} from "../../Reservation";

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

public reservations: any;

  constructor(private reservationService: ReservationService) {
  }

  ngOnInit() {
    this.getReservations();
  }


public getReservations(): void {
    this.reservationService.getReservations().subscribe((reservations: Reservation[]) => {
        this.reservations =  reservations;
      },
    )
  }
}
