import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppNewCpuComponent } from './app-new-cpu.component';

describe('AppNewProcessorComponent', () => {
  let component: AppNewCpuComponent;
  let fixture: ComponentFixture<AppNewCpuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppNewCpuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppNewCpuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
