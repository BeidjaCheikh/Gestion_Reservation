import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonEditeComponent } from './person-edite.component';

describe('PersonEditeComponent', () => {
  let component: PersonEditeComponent;
  let fixture: ComponentFixture<PersonEditeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersonEditeComponent]
    });
    fixture = TestBed.createComponent(PersonEditeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
