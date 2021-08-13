import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppNewPhoneComponent } from './app-new-phone.component';

describe('AppNewPhoneComponent', () => {
  let component: AppNewPhoneComponent;
  let fixture: ComponentFixture<AppNewPhoneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppNewPhoneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppNewPhoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
