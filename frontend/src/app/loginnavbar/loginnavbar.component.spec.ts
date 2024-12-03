import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginnavbarComponent } from './loginnavbar.component';

describe('LoginnavbarComponent', () => {
  let component: LoginnavbarComponent;
  let fixture: ComponentFixture<LoginnavbarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LoginnavbarComponent]
    });
    fixture = TestBed.createComponent(LoginnavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
