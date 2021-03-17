import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AppPhonesListComponent} from './components/app-phones-list/app-phones-list.component';
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
import {AppPhoneComponent} from './components/app-phone/app-phone.component';
import {MatDividerModule} from '@angular/material/divider';
import {NewPhoneModelComponent} from './components/new-phone-model/new-phone-model.component';
import {MatDialogModule} from '@angular/material/dialog';
import {AppDialogWithNameComponent} from './components/app-dialog-with-name/app-dialog-with-name.component';
import {HttpClientModule} from '@angular/common/http';
import { AppNewOperationSystemWithVersionDialogComponent } from './components/app-new-operation-system-with-version-dialog/app-new-operation-system-with-version-dialog.component';
import { AppNewCpuComponent } from './components/app-new-cpu/app-new-cpu.component';
import {AppNewGpuComponent} from './components/app-new-gpu/app-new-gpu.component';


@NgModule({
  declarations: [
    AppComponent,
    AppPhonesListComponent,
    AppHomePageComponent,
    AppPhoneComponent,
    NewPhoneModelComponent,
    AppDialogWithNameComponent,
    AppNewOperationSystemWithVersionDialogComponent,
    AppNewCpuComponent,
    AppNewGpuComponent,
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
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
