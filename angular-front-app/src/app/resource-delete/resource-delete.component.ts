import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {ResourceService} from "../services/resource.service";

@Component({
  selector: 'app-resource-delete',
  templateUrl: './resource-delete.component.html',
  styleUrls: ['./resource-delete.component.css']
})
export class ResourceDeleteComponent implements OnInit{

  private resourceId! :number;
  constructor(private Httpclient:HttpClient ,private activate:ActivatedRoute, private router:Router, private resourceService:ResourceService) {
    this.resourceId=activate.snapshot.params['id']
  }

  ngOnInit(): void {
    this.getResourcesById();
  }
  public getResourcesById(): void {
    this.resourceService.deleteResource(this.resourceId).subscribe(value => {
      this.goToResourceList();
    })
  }

  goToResourceList() {
    this.router.navigate(['/resources']);
  }


}

