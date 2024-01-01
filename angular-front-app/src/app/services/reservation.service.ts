import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Reservation} from "../../Reservation";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private apiReservationUrl = 'http://localhost:9999/reservation-service/api/reservations';

  constructor(private http: HttpClient) {}

  public getReservations(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.apiReservationUrl);
  }

  public addReservation(reservation: Reservation): Observable<Reservation> {
    return this.http.post<Reservation>(`${this.apiReservationUrl}/create`, reservation);
  }

  public updateReservation(reservationId: number, reservation: Reservation): Observable<Reservation> {
    return this.http.put<Reservation>(`${this.apiReservationUrl}/update/${reservationId}`, reservation);
  }
  public getReservationById(reservationId: number): Observable<Reservation> {
    return this.http.get<Reservation>(`${this.apiReservationUrl}/${reservationId}`);
  }

  public deleteReservation(reservationId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiReservationUrl}/delete/${reservationId}`);
  }
}
