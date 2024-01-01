import { Component } from '@angular/core';
import {PersonService} from "../services/person.service";
import {Router} from "@angular/router";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-person-create',
  templateUrl: './person-create.component.html',
  styleUrls: ['./person-create.component.css']
})
export class PersonCreateComponent {
  constructor(private personService:PersonService ,private router:Router){

  }

  onSubmit(createForm: NgForm) {
    this.personService.addPerson(createForm.value).subscribe(value => {
      this.router.navigate(['/persons']);
    })

  }
}
