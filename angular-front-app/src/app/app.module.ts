import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import { PersonsComponent } from './persons/persons.component';
import { ResourcesComponent } from './resources/resources.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { PersonCreateComponent } from './person-create/person-create.component';
import { PersonEditeComponent } from './person-edite/person-edite.component';
import { PersonDeleteComponent } from './person-delete/person-delete.component';
import { ReservationCreateComponent } from './reservation-create/reservation-create.component';
import { ResourceCreateComponent } from './resource-create/resource-create.component';
import { ResourceEditeComponent } from './resource-edite/resource-edite.component';
import { ResourceDeleteComponent } from './resource-delete/resource-delete.component';
import { PersonReservationComponent } from './person-reservation/person-reservation.component';
import {FormsModule} from "@angular/forms";
function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'reservation-realm',
        clientId: 'reservation-client'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}
@NgModule({
  declarations: [
    AppComponent,
    PersonsComponent,
    ResourcesComponent,
    ReservationsComponent,
    PersonCreateComponent,
    PersonEditeComponent,
    PersonDeleteComponent,
    ReservationCreateComponent,
    ResourceCreateComponent,
    ResourceEditeComponent,
    ResourceDeleteComponent,
    PersonReservationComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule,
    FormsModule
  ],
  providers: [
    {provide:APP_INITIALIZER,deps:[KeycloakService],useFactory:initializeKeycloak,multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
