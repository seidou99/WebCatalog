import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppNewOperationSystemWithVersionDialogComponent } from './app-new-operation-system-with-version-dialog.component';

describe('AppNewOperationSystemWithVersionDialogComponent', () => {
  let component: AppNewOperationSystemWithVersionDialogComponent;
  let fixture: ComponentFixture<AppNewOperationSystemWithVersionDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppNewOperationSystemWithVersionDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppNewOperationSystemWithVersionDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
