import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonReservationComponent } from './person-reservation.component';

describe('PersonReservationComponent', () => {
  let component: PersonReservationComponent;
  let fixture: ComponentFixture<PersonReservationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersonReservationComponent]
    });
    fixture = TestBed.createComponent(PersonReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
