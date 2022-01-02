import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, Validators} from "@angular/forms";
import {Role, SearchType, User} from "../../model/User";
import {UserService} from "../../services/user.service";
import {UtilService} from "../../services/util.service";
import {ShopService} from "../../services/shop.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ApiConstants, ValidationConstants} from "../../Constants";
import {ActivatedRoute} from "@angular/router";
import {Shop} from "../../model/shop";

@Component({
  selector: 'app-edit-shop',
  templateUrl: './edit-shop.component.html',
  styleUrls: ['./edit-shop.component.css']
})
export class EditShopComponent implements OnInit {

  SearchType = SearchType;
  adminSearchForm = this.fb.group({
    name: [''],
    surname: [''],
    email: [''],
    selectedSearchType: [SearchType.NAME_AND_SURNAME, [Validators.required]]
  });
  adminSearchFormError: string;
  shopAdmins: Array<User> = [];
  editShopForm = this.fb.group({
    name: ['', [Validators.required]],
    shopAdmin: [null, [Validators.required]],
    contactInfoList: this.fb.array([this.fb.control('', Validators.required)]),
    shopDescription: ['', [Validators.required]],
    addresses: this.fb.array([this.fb.control('', [Validators.required])])
  });
  shop: Shop = null;

  constructor(protected userService: UserService, protected fb: FormBuilder, protected util: UtilService, protected shopService: ShopService, protected snackBar: MatSnackBar, protected route: ActivatedRoute) {
  }

  removeAddressControl(i: number): void {
    const addresses = this.editShopForm.get('addresses') as FormArray;
    addresses.removeAt(i);
  }

  removeContractInfoControl(i: number): void {
    const contactInfoList = this.editShopForm.get('contactInfoList') as FormArray;
    contactInfoList.removeAt(i);
  }

  async ngOnInit(): Promise<void> {
    const id = this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM);
    const shop = await this.shopService.getById(id).toPromise();
    console.log('existing shop: ', shop);
    for (let i = 0; i < shop.addresses.length - 1; i++) {
      this.addAddressControl();
    }
    for (let i = 0; i < shop.contactInfoList.length - 1; i++) {
      this.addContactInfoControl();
    }
    this.shopAdmins.push(shop.shopAdmin);
    this.editShopForm.patchValue({
      name: shop.name,
      shopDescription: shop.shopDescription,
      addresses: shop.addresses,
      contactInfoList: shop.contactInfoList,
      shopAdmin: shop.shopAdmin
    });
    this.shop = shop;
  }

  getAddresses(): FormArray {
    return this.editShopForm.get('addresses') as FormArray;
  }

  addAddressControl(): void {
    const addresses = this.editShopForm.get('addresses') as FormArray;
    addresses.push(this.fb.control('', [Validators.required]));
  }

  addContactInfoControl(): void {
    const contactInfoList = this.editShopForm.get('contactInfoList') as FormArray;
    contactInfoList.push(this.fb.control('', [Validators.required]));
  }

  getContactInfoList(): FormArray {
    return this.editShopForm.get('contactInfoList') as FormArray;
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

  async saveShop(): Promise<void> {
    const rawValue = this.editShopForm.getRawValue();
    console.log('form value', rawValue);
    if (this.editShopForm.invalid) {
      this.editShopForm.markAllAsTouched();
    }
    let message = 'Магазин сохранен';
    try {
      rawValue.id = this.shop.id;
      const createdShop = await this.shopService.edit(rawValue).toPromise();
      console.log('created shop', createdShop);
    } catch (e) {
      message = 'Ошибка при сохранении магазина';
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
