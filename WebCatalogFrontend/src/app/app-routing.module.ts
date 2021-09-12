import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppPhonesListComponent} from './components/app-phones-list/app-phones-list.component';
import {AppHomePageComponent} from './components/app-home-page/app-home-page.component';
import {AppPhoneModelComponent} from './components/app-phone-model/app-phone-model.component';
import {AppNewPhoneModelComponent} from './components/app-new-phone-model/app-new-phone-model.component';
import {AppPhoneModelsListComponent} from './components/app-phone-models-list/app-phone-models-list.component';
import {AppNewPhoneComponent} from './components/app-new-phone/app-new-phone.component';
import {AppPhoneComponent} from './components/app-phone/app-phone.component';
import {AppGeneratorComponent} from './components/app-generator/app-generator.component';
import {AppErrorComponent} from './components/app-error/app-error.component';

const routes: Routes = [
  {path: 'generator', component: AppGeneratorComponent},
  {path: 'phone-models/new', component: AppNewPhoneModelComponent},
  {path: 'phone-models/:id', component: AppPhoneModelComponent},
  {path: 'phones/new', component: AppNewPhoneComponent},
  {path: 'phones/:id', component: AppPhoneComponent},
  {path: 'phones', component: AppPhonesListComponent},
  {path: 'phone-models', component: AppPhoneModelsListComponent},
  {path: '', component: AppHomePageComponent},
  {path: '**', component: AppErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
