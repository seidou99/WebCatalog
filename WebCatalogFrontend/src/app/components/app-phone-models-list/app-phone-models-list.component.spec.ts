import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppPhoneModelsListComponent } from './app-phone-models-list.component';

describe('AppPhoneModelsListComponent', () => {
  let component: AppPhoneModelsListComponent;
  let fixture: ComponentFixture<AppPhoneModelsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppPhoneModelsListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppPhoneModelsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
