import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceEditeComponent } from './resource-edite.component';

describe('ResourceEditeComponent', () => {
  let component: ResourceEditeComponent;
  let fixture: ComponentFixture<ResourceEditeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResourceEditeComponent]
    });
    fixture = TestBed.createComponent(ResourceEditeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
