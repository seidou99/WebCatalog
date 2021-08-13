import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppNewPhoneModelComponent } from './app-new-phone-model.component';

describe('NewPhoneModelComponent', () => {
  let component: AppNewPhoneModelComponent;
  let fixture: ComponentFixture<AppNewPhoneModelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppNewPhoneModelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppNewPhoneModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
