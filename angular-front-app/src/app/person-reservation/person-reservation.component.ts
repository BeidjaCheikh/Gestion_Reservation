import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {PersonService} from "../services/person.service";

@Component({
  selector: 'app-person-reservation',
  templateUrl: './person-reservation.component.html',
  styleUrls: ['./person-reservation.component.css']
})
export class PersonReservationComponent implements OnInit{

  public reservations:any;
  private personId! :number;

  constructor(private Httpclient:HttpClient ,private activate:ActivatedRoute, private router:Router, private personService:PersonService) {
    this.personId=activate.snapshot.params['id']
  }

  ngOnInit(): void {
    this.getReservationPerson();
  }

  getReservationPerson(){
    this.personService.personReservation(this.personId).subscribe(value =>
      {
        this.reservations=value;
      }
    )}


  addReservation() {
    this.router.navigateByUrl('/reservations/create/'+this.personId);
  }
}

