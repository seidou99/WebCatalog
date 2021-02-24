import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppDialogWithNameAndDescriptionComponent } from './app-dialog-with-name-and-description.component';

describe('AppDialogWithNameAndDescriptionComponent', () => {
  let component: AppDialogWithNameAndDescriptionComponent;
  let fixture: ComponentFixture<AppDialogWithNameAndDescriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppDialogWithNameAndDescriptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AppDialogWithNameAndDescriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
