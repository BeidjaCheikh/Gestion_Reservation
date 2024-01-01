import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from "./gaurds/auth.guard";
import {ResourcesComponent} from "./resources/resources.component";
import {ReservationsComponent} from "./reservations/reservations.component";
import {ResourceEditeComponent} from "./resource-edite/resource-edite.component";
import {ResourceDeleteComponent} from "./resource-delete/resource-delete.component";
import {ResourceCreateComponent} from "./resource-create/resource-create.component";
import {PersonsComponent} from "./persons/persons.component";
import {PersonCreateComponent} from "./person-create/person-create.component";
import {PersonEditeComponent} from "./person-edite/person-edite.component";
import {PersonDeleteComponent} from "./person-delete/person-delete.component";
import {ReservationCreateComponent} from "./reservation-create/reservation-create.component";
import {PersonReservationComponent} from "./person-reservation/person-reservation.component";

const routes: Routes = [
  {path:"resources" ,component:ResourcesComponent,canActivate:[AuthGuard],data:{roles:['ADMIN']}},
  {path:"reservations" ,component:ReservationsComponent ,canActivate:[AuthGuard],data:{roles:['ADMIN']}},
  {path:"resources/edite/:id" ,component:ResourceEditeComponent},
  {path:"resources/delete/:id" ,component:ResourceDeleteComponent},
  {path:"resources/create" ,component:ResourceCreateComponent},
  {path:"persons" ,component:PersonsComponent ,canActivate:[AuthGuard],data:{roles:['ADMIN']}},
  {path:"persons/create" ,component:PersonCreateComponent},
  {path:"persons/edite/:id" ,component:PersonEditeComponent},
  {path:"persons/delete/:id" ,component:PersonDeleteComponent},
  {path:"persons/reservation/:id" ,component:PersonReservationComponent},
  {path:"reservations/create/:id" ,component:ReservationCreateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
