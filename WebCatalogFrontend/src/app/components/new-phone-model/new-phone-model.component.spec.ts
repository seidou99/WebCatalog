import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPhoneModelComponent } from './new-phone-model.component';

describe('NewPhoneModelComponent', () => {
  let component: NewPhoneModelComponent;
  let fixture: ComponentFixture<NewPhoneModelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewPhoneModelComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPhoneModelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
