import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Person} from "../../Person";
import {Reservation} from "../../Reservation";

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private apiPersonUrl = 'http://localhost:9999/reservation-service/api/persons';
  private apiPersonRUrls='http://localhost:9999/reservation-service/api/reservations';
  constructor(private http: HttpClient) {}

  public getPersons(): Observable<Person[]> {
    return this.http.get<Person[]>(this.apiPersonUrl);
  }

  public addPerson(person: Person): Observable<Person> {
    return this.http.post<Person>(`${this.apiPersonUrl}/create`, person);
  }

  public updatePerson(personId: number, person: Person): Observable<Person> {
    return this.http.put<Person>(`${this.apiPersonUrl}/update/${personId}`, person);
  }
  public getPersonById(personId: number):  Observable<Person> {
    return this.http.get<Person>(`${this.apiPersonUrl}/${personId}`);
  }

  public deletePerson(personId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiPersonUrl}/delete/${personId}`);
  }
  public personReservation(personId: number): Observable<Reservation> {
    return this.http.get<Reservation>(`${this.apiPersonRUrls}/person/${personId}`);
  }
}
