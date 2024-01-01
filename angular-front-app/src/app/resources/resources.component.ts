import {Component, OnInit} from '@angular/core';
import {ResourceService} from "../services/resource.service";
import {Router} from "@angular/router";
import {Resource} from "../../Resource";

@Component({
  selector: 'app-resources',
  templateUrl: './resources.component.html',
  styleUrls: ['./resources.component.css']
})
export class ResourcesComponent implements OnInit {

  public resources: any;

  constructor(private resourceService: ResourceService, private route :Router) {
  }

  ngOnInit() {
    this.getResources();
  }


  public getResources(): void {
    this.resourceService.getResources().subscribe((resource: Resource[]) => {
        this.resources =  resource;
      },
    )
  }

  editResource(id:number) {
    this.route.navigateByUrl('/resources/edite/'+id);

  }


  deleteResource(id:number) {
    this.route.navigateByUrl('/resources/delete/'+id);

  }

  addResource() {
    this.route.navigateByUrl('/resources/create');

  }
}

