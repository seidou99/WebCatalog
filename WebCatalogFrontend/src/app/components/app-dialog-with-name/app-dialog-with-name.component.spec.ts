import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppDialogWithNameComponent } from './app-dialog-with-name.component';

describe('AppDialogWithNameAndDescriptionComponent', () => {
  let component: AppDialogWithNameComponent;
  let fixture: ComponentFixture<AppDialogWithNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppDialogWithNameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppDialogWithNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
