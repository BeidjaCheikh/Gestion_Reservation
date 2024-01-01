import {Component, OnInit} from '@angular/core';
import {ResourceService} from "../services/resource.service";
import {Router} from "@angular/router";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-resource-create',
  templateUrl: './resource-create.component.html',
  styleUrls: ['./resource-create.component.css']
})
export class ResourceCreateComponent implements OnInit{
  constructor(private resourceService:ResourceService ,private router:Router){

  }
  ngOnInit(): void {

  }
  onSubmit(createForm: NgForm) {
    console.log(createForm.value);
    this.resourceService.addResource(createForm.value).subscribe(value => {
      this.router.navigate(['/resources']);
    })
  }
}

