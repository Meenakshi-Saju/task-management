import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatetaskComponent } from './updatetask.component';

describe('UpdatetaskComponent', () => {
  let component: UpdatetaskComponent;
  let fixture: ComponentFixture<UpdatetaskComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdatetaskComponent]
    });
    fixture = TestBed.createComponent(UpdatetaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
