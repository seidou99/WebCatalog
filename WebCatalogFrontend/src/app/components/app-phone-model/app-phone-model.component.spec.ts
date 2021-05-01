import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppPhoneModelComponent } from './app-phone-model.component';

describe('AppPhoneComponent', () => {
  let component: AppPhoneModelComponent;
  let fixture: ComponentFixture<AppPhoneModelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppPhoneModelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppPhoneModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
