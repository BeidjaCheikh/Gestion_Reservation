import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {PersonService} from "../services/person.service";

@Component({
  selector: 'app-person-delete',
  templateUrl: './person-delete.component.html',
  styleUrls: ['./person-delete.component.css']
})
export class PersonDeleteComponent implements OnInit{

  private personId! :number;
  constructor(private Httpclient:HttpClient ,private activate:ActivatedRoute, private router:Router, private personService:PersonService) {
    this.personId=activate.snapshot.params['id']
  }

  ngOnInit(): void {
    this.getPersonById();
  }
  public getPersonById(): void {
    this.personService.deletePerson(this.personId).subscribe(value => {
      this.router.navigate(['/persons']);

    })
  }




}
