import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {PhonesListComponent} from './components/app-phones-list/phones-list.component';
import {AppHomePageComponent} from './components/app-home-page/app-home-page.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatOptionModule} from '@angular/material/core';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {PhoneModelComponent} from './components/app-phone-model/phone-model.component';
import {MatDividerModule} from '@angular/material/divider';
import {AppNewPhoneModelComponent} from './components/app-new-phone-model/app-new-phone-model.component';
import {MatDialogModule} from '@angular/material/dialog';
import {AppDialogWithNameComponent} from './components/app-dialog-with-name/app-dialog-with-name.component';
import {HttpClientModule} from '@angular/common/http';
import { AppNewOperationSystemWithVersionDialogComponent } from './components/app-new-operation-system-with-version-dialog/app-new-operation-system-with-version-dialog.component';
import { AppNewPhoneCpuComponent } from './components/app-new-cpu/app-new-phone-cpu.component';
import {AppNewGpuComponent} from './components/app-new-gpu/app-new-gpu.component';
import { AppPhoneModelsListComponent } from './components/app-phone-models-list/app-phone-models-list.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import { AppNewPhoneComponent } from './components/app-new-phone/app-new-phone.component';
import { AppPhoneComponent } from './components/app-phone/app-phone.component';
import { AppGeneratorComponent } from './components/app-generator/app-generator.component';
import { AppErrorComponent } from './components/app-error/app-error.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { SelectImagesComponent } from './components/select-images/select-images.component';
import { EditPhoneModelComponent } from './components/edit-phone-model/edit-phone-model.component';


@NgModule({
  declarations: [
    AppComponent,
    PhonesListComponent,
    AppHomePageComponent,
    PhoneModelComponent,
    AppNewPhoneModelComponent,
    AppDialogWithNameComponent,
    AppNewOperationSystemWithVersionDialogComponent,
    AppNewPhoneCpuComponent,
    AppNewGpuComponent,
    AppPhoneModelsListComponent,
    AppNewPhoneComponent,
    AppPhoneComponent,
    AppGeneratorComponent,
    AppErrorComponent,
    NavbarComponent,
    SelectImagesComponent,
    EditPhoneModelComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatGridListModule,
    ReactiveFormsModule,
    MatOptionModule,
    MatAutocompleteModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatCheckboxModule,
    MatIconModule,
    MatButtonModule,
    MatDividerModule,
    MatDialogModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatPaginatorModule,
    MatSnackBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
