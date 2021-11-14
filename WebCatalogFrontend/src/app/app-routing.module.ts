import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PhonesListComponent} from './components/app-phones-list/phones-list.component';
import {AppHomePageComponent} from './components/app-home-page/app-home-page.component';
import {PhoneModelComponent} from './components/app-phone-model/phone-model.component';
import {AppNewPhoneModelComponent} from './components/app-new-phone-model/app-new-phone-model.component';
import {AppPhoneModelsListComponent} from './components/app-phone-models-list/app-phone-models-list.component';
import {AppNewPhoneComponent} from './components/app-new-phone/app-new-phone.component';
import {AppPhoneComponent} from './components/app-phone/app-phone.component';
import {AppGeneratorComponent} from './components/app-generator/app-generator.component';
import {AppErrorComponent} from './components/app-error/app-error.component';
import {EditPhoneModelComponent} from "./components/edit-phone-model/edit-phone-model.component";
import {EditPhoneComponent} from "./components/edit-phone/edit-phone.component";
import {ShopsListComponent} from "./components/shops-list/shops-list.component";
import {ShopComponent} from "./components/shop/shop.component";
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {NewShopComponent} from "./components/new-shop/new-shop.component";

const routes: Routes = [
  {path: 'generator', component: AppGeneratorComponent},
  {path: 'phone-models/new', component: AppNewPhoneModelComponent, pathMatch: 'full'},
  {path: 'phone-models/:id', component: PhoneModelComponent, pathMatch: 'full'},
  {path: 'phones/new', component: AppNewPhoneComponent, pathMatch: 'full'},
  {path: 'phones/:id', component: AppPhoneComponent, pathMatch: 'full'},
  {path: 'phones', component: PhonesListComponent, pathMatch: 'full'},
  {path: 'phones/:id/edit', component: EditPhoneComponent, pathMatch: 'full'},
  {path: 'phone-models', component: AppPhoneModelsListComponent, pathMatch: 'full'},
  {path: 'phone-models/:id/edit', component: EditPhoneModelComponent, pathMatch: 'full'},
  {path: 'shops', component: ShopsListComponent, pathMatch: 'full'},
  {path: 'shops/new', component: NewShopComponent, pathMatch: 'full'},
  {path: 'shops/:id', component: ShopComponent, pathMatch: 'full'},
  {path: 'login', component: LoginComponent, pathMatch: 'full'},
  {path: 'register', component: RegisterComponent, pathMatch: 'full'},
  {path: '', component: AppHomePageComponent},
  {path: '**', component: AppErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
