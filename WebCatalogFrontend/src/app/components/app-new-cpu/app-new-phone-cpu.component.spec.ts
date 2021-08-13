import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppNewPhoneCpuComponent } from './app-new-phone-cpu.component';

describe('AppNewProcessorComponent', () => {
  let component: AppNewPhoneCpuComponent;
  let fixture: ComponentFixture<AppNewPhoneCpuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppNewPhoneCpuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppNewPhoneCpuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
