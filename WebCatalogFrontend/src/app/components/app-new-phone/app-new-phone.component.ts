import {Component, OnInit} from '@angular/core';
import {FormControlNames} from "../../Constants";
import {PhoneModel} from "../../model/phone-model";
import {PhoneModelService} from "../../services/phone-model.service";
import {BaseDataObjectWithName} from "../../model/base-data-object";
import {FormBuilder, Validators} from "@angular/forms";
import {PhoneService} from "../../services/phone.service";

@Component({
  selector: 'app-app-new-phone',
  templateUrl: './app-new-phone.component.html',
  styleUrls: ['./app-new-phone.component.css']
})
export class AppNewPhoneComponent implements OnInit {

  FormControlNames = FormControlNames;
  phoneModels: Array<PhoneModel> = [];
  selectedPhoneModel: PhoneModel = null;
  phoneForm = this.fb.group({
    name: [null, [Validators.required]],
    phoneModel: [null, [Validators.required]],
    ramAndRomVariant: [null, [Validators.required]],
    bodyColor: [null, [Validators.required]]
  });

  constructor(public phoneModelService: PhoneModelService, public fb: FormBuilder, public phoneService: PhoneService) {
  }

  async ngOnInit(): Promise<void> {
    this.phoneModels = await this.phoneModelService.getAll().toPromise();
  }

  nameDisplayFunction(object: BaseDataObjectWithName): string {
    let result = '';
    if (object && object.name) {
      result = object.name;
    }
    return result;
  }

  onPhoneModelChange($event: any): void {
    if (!$event.id) {
      this.selectedPhoneModel = null;
    } else {
      this.selectedPhoneModel = $event as PhoneModel;
    }
  }

  getOperationSystemName(): string {
    let result = '';
    if (this.selectedPhoneModel !== null) {
      result = this.selectedPhoneModel.operationSystemWithVersion.operationSystem.name + ' ' +
        this.selectedPhoneModel.operationSystemWithVersion.version;
    }
    return result;
  }

  async createPhoneModel(): Promise<void> {
    if (this.phoneForm.invalid) {
      this.phoneForm.markAllAsTouched();
      return;
    }
    const rawValue = this.phoneForm.getRawValue();
    console.log(rawValue);
    await this.phoneService.save(rawValue).toPromise();
    console.log('created');
  }

}
