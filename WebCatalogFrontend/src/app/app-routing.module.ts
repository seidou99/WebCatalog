import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppPhonesListComponent} from './components/app-phones-list/app-phones-list.component';
import {AppHomePageComponent} from './components/app-home-page/app-home-page.component';
import {AppPhoneModelComponent} from './components/app-phone/app-phone-model.component';
import {AppNewPhoneModelComponent} from './components/new-phone-model/app-new-phone-model.component';
import {AppPhoneModelsListComponent} from './components/app-phone-models-list/app-phone-models-list.component';

const routes: Routes = [
  {path: 'phone-models/new', component: AppNewPhoneModelComponent},
  {path: 'phone-models/:id', component: AppPhoneModelComponent},
  {path: 'phones', component: AppPhonesListComponent},
  {path: 'phone-models', component: AppPhoneModelsListComponent},
  {path: '', component: AppHomePageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
