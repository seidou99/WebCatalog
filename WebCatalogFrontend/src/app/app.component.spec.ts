import {TestBed} from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import {AppComponent} from './app.component';
import {AppPhonesListComponent} from "./components/app-phones-list/app-phones-list.component";
import {AppHomePageComponent} from "./components/app-home-page/app-home-page.component";
import {AppPhoneModelComponent} from "./components/app-phone/app-phone-model.component";
import {AppNewPhoneModelComponent} from "./components/new-phone-model/app-new-phone-model.component";
import {AppDialogWithNameComponent} from "./components/app-dialog-with-name/app-dialog-with-name.component";
import {AppNewOperationSystemWithVersionDialogComponent} from "./components/app-new-operation-system-with-version-dialog/app-new-operation-system-with-version-dialog.component";
import {AppNewCpuComponent} from "./components/app-new-cpu/app-new-cpu.component";
import {AppNewGpuComponent} from "./components/app-new-gpu/app-new-gpu.component";
import {AppPhoneModelsListComponent} from "./components/app-phone-models-list/app-phone-models-list.component";

describe('Application integration test', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent,
        AppPhonesListComponent,
        AppHomePageComponent,
        AppPhoneModelComponent,
        AppNewPhoneModelComponent,
        AppDialogWithNameComponent,
        AppNewOperationSystemWithVersionDialogComponent,
        AppNewCpuComponent,
        AppNewGpuComponent,
        AppPhoneModelsListComponent,
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('.content span').textContent).toContain('WebCatalogFrontend app is running!');
  });

  it('should create phone model', () => {
    const fixture = TestBed.createComponent(AppNewPhoneModelComponent);
    const newPhoneModelComponent = fixture.componentInstance;
  });
});
