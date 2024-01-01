import {Component, OnInit} from '@angular/core';
import {PersonService} from "../services/person.service";
import {Router} from "@angular/router";
import {Person} from "../../Person";

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {

public persons: any;

  constructor(private personService: PersonService ,private router:Router) {
  }

  ngOnInit() {
    this.getPersons();
  }


public getPersons(): void {
    this.personService.getPersons().subscribe((response: Person[]) => {
        this.persons = response;
      },
    )
  }

  editPerson(id:number) {
    this.router.navigateByUrl('/persons/edite/'+id);
  }

  deletePerson(id:number) {
    this.router.navigateByUrl('/persons/delete/'+id);

  }

  addPerson() {
    this.router.navigateByUrl('/persons/create');
  }

  personReservation(id:number) {
    this.router.navigateByUrl('/persons/reservation/'+id);
  }
}
