import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppNewGpuComponent } from './app-new-gpu.component';

describe('AppNewGpuComponent', () => {
  let component: AppNewGpuComponent;
  let fixture: ComponentFixture<AppNewGpuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppNewGpuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppNewGpuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
