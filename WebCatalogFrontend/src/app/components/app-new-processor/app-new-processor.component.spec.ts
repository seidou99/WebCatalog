import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppNewProcessorComponent } from './app-new-processor.component';

describe('AppNewProcessorComponent', () => {
  let component: AppNewProcessorComponent;
  let fixture: ComponentFixture<AppNewProcessorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppNewProcessorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppNewProcessorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
