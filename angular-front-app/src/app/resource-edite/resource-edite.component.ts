import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {ResourceService} from "../services/resource.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-resource-edite',
  templateUrl: './resource-edite.component.html',
  styleUrls: ['./resource-edite.component.css']
})
export class ResourceEditeComponent implements OnInit{

  public resourceEdit:any;
  private resourceId! :number;
  constructor(private Httpclient:HttpClient ,private activate:ActivatedRoute, private router:Router, private resourceService:ResourceService) {
    this.resourceId=activate.snapshot.params['id']
  }

  ngOnInit(): void {
    this.getResourcesById();
    // console.log(this.resourceEdit)
  }
  public getResourcesById(): void {
    this.resourceService.getResourceById(this.resourceId).subscribe(
      value => {
        this.resourceEdit = value;
      },
      error => {
        console.log(error);
      }
    );
  }

  onSubmit(editForm: NgForm) {
    this.resourceService.updateResource(this.resourceId,editForm.value).subscribe(value => {
      this.goToResourceList()
    })
    console.log(editForm.value)
  }
  goToResourceList() {
    this.router.navigate(['/resources']);
  }

}
