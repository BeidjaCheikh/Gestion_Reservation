import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {PersonService} from "../services/person.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-person-edite',
  templateUrl: './person-edite.component.html',
  styleUrls: ['./person-edite.component.css']
})
export class PersonEditeComponent implements OnInit{

public personEdit:any;
private personId! :number;
  constructor(private Httpclient:HttpClient ,private activate:ActivatedRoute, private router:Router, private personService:PersonService) {
    this.personId=activate.snapshot.params['id']
  }

  ngOnInit(): void {
    this.getPersonById();
    // console.log(this.resourceEdit)
  }
public getPersonById(): void {
    this.personService.getPersonById(this.personId).subscribe(
      value => {
        this.personEdit = value;
      },
      error => {
        console.log(error);
      }
    );
  }

  onSubmit(editForm: NgForm) {
    this.personService.updatePerson(this.personId,editForm.value).subscribe(value => {
      this.router.navigate(['/persons']);
    })
    console.log(editForm.value)
  }




}
