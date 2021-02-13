import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppPhonesListComponent } from './app-phones-list.component';

describe('AppPhonesListComponent', () => {
  let component: AppPhonesListComponent;
  let fixture: ComponentFixture<AppPhonesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppPhonesListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppPhonesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
