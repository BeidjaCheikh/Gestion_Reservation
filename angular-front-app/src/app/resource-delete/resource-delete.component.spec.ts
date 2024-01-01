import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResourceDeleteComponent } from './resource-delete.component';

describe('ResourceDeleteComponent', () => {
  let component: ResourceDeleteComponent;
  let fixture: ComponentFixture<ResourceDeleteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResourceDeleteComponent]
    });
    fixture = TestBed.createComponent(ResourceDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
