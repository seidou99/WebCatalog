import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhoneModelComponent } from './phone-model.component';

describe('AppPhoneComponent', () => {
  let component: PhoneModelComponent;
  let fixture: ComponentFixture<PhoneModelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PhoneModelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PhoneModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
