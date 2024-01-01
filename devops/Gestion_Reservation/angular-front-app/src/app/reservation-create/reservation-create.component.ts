import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ReservationService} from "../services/reservation.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-reservation-create',
  templateUrl: './reservation-create.component.html',
  styleUrls: ['./reservation-create.component.css']
})
export class ReservationCreateComponent implements OnInit{

  public personId! :number;
  constructor(private activate:ActivatedRoute, private router:Router, private reservationService:ReservationService) {
    this.personId=activate.snapshot.params['id']
  }

  ngOnInit(): void {
  }


  onSubmit(createForm: NgForm) {
    console.log(createForm.value)
    this.reservationService.addReservation(createForm.value).subscribe(value =>
    {
      this.router.navigate(['/persons/reservation/'+this.personId]);
    })

  }
}
