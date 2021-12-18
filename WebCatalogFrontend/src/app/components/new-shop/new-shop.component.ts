import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {FormArray, FormBuilder, Validators} from "@angular/forms";
import {Role, SearchType, User} from 'src/app/model/User';
import {UtilService} from "../../services/util.service";
import {ValidationConstants} from "../../Constants";
import {ShopService} from "../../services/shop.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-new-shop',
  templateUrl: './new-shop.component.html',
  styleUrls: ['./new-shop.component.css']
})
export class NewShopComponent implements OnInit {

  SearchType = SearchType;
  adminSearchForm = this.fb.group({
    name: [''],
    surname: [''],
    email: [''],
    selectedSearchType: [SearchType.NAME_AND_SURNAME, [Validators.required]]
  });
  adminSearchFormError: string;
  shopAdmins: Array<User> = [];
  createShopForm = this.fb.group({
    name: ['', [Validators.required]],
    shopAdmin: [null, [Validators.required]],
    contactInfoList: this.fb.array([this.fb.control('', Validators.required)]),
    shopDescription: ['', [Validators.required]],
    addresses: this.fb.array([this.fb.control('', [Validators.required])])
  });

  constructor(protected userService: UserService, protected fb: FormBuilder, protected util: UtilService, protected shopService: ShopService, protected snackBar: MatSnackBar) {
  }

  removeAddressControl(i: number): void {
    const addresses = this.createShopForm.get('addresses') as FormArray;
    addresses.removeAt(i);
  }

  removeContractInfoControl(i: number): void {
    const contactInfoList = this.createShopForm.get('contactInfoList') as FormArray;
    contactInfoList.removeAt(i);
  }

  ngOnInit(): void {
  }

  getAddresses(): FormArray {
    return this.createShopForm.get('addresses') as FormArray;
  }

  addAddressControl(): void {
    const addresses = this.createShopForm.get('addresses') as FormArray;
    addresses.push(this.fb.control('', [Validators.required]));
  }

  addContactInfoControl(): void {
    const contactInfoList = this.createShopForm.get('contactInfoList') as FormArray;
    contactInfoList.push(this.fb.control('', [Validators.required]));
  }

  getContactInfoList(): FormArray {
    return this.createShopForm.get('contactInfoList') as FormArray;
  }

  async searchShopAdmin(): Promise<void> {
    const rawValue = this.adminSearchForm.getRawValue();
    console.log('search shop admin requirest', rawValue);
    if (!this.validateAdminSearchForm(rawValue)) {
      window.alert(this.adminSearchFormError);
      return;
    }
    this.shopAdmins = await this.userService.find(rawValue.name, rawValue.surname, rawValue.email, rawValue.selectedSearchType, Role.SHOP_ADMIN).toPromise();
    console.log('shop admins', this.shopAdmins);
  }

  async createShop(): Promise<void> {
    const rawValue = this.createShopForm.getRawValue();
    console.log('form value', rawValue);
    if (this.createShopForm.invalid) {
      this.createShopForm.markAllAsTouched();
    }
    let message = 'Магазин создан';
    try {
      const createdShop = await this.shopService.create(rawValue).toPromise();
      console.log('created shop', createdShop);
    } catch (e) {
      message = 'Ошибка при создании магазина';
    }
    this.snackBar.open(message, 'OK', {duration: 3000});
  }

  // return true if form is valid, else false
  // also sets error string and clears it if form is valid
  validateAdminSearchForm(formValue: any): boolean {
    const selectedSearchType = formValue.selectedSearchType;
    const name = formValue.name;
    const surname = formValue.surname;
    const email = formValue.email;
    if (SearchType.NAME_AND_SURNAME === selectedSearchType && this.util.isStringEmpty(name) && this.util.isStringEmpty(surname)) {
      this.adminSearchFormError = ValidationConstants.NAME_OR_SURNAME_REQUIRED;
      return false;
    } else if (SearchType.EMAIL === selectedSearchType && this.util.isStringEmpty(email)) {
      this.adminSearchFormError = ValidationConstants.EMAIL_REQUIRED;
      return false;
    }
    this.adminSearchFormError = null;
    return true;
  }

}
