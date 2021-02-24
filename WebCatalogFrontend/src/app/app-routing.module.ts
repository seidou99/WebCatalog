import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppPhonesListComponent} from './components/app-phones-list/app-phones-list.component';
import {AppHomePageComponent} from './components/app-home-page/app-home-page.component';
import {AppPhoneComponent} from './components/app-phone/app-phone.component';
import {NewPhoneModelComponent} from './components/new-phone-model/new-phone-model.component';

const routes: Routes = [
  {path: 'phones/new', component: NewPhoneModelComponent},
  {path: 'phones/:phoneId', component: AppPhoneComponent},
  {path: 'phones', component: AppPhonesListComponent},
  {path: '', component: AppHomePageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
