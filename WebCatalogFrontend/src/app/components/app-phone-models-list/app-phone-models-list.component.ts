import {Component, OnInit} from '@angular/core';
import {PhoneModelFilter} from '../../model/phone-model-filter';
import {PhoneModelService} from "../../services/phone-model.service";
import {PhoneModel} from "../../model/phone-model";
import {StringConstants} from "../../Constants";

@Component({
  selector: 'app-app-phone-models-list',
  templateUrl: './app-phone-models-list.component.html',
  styleUrls: ['./app-phone-models-list.component.css']
})
export class AppPhoneModelsListComponent implements OnInit {

  phoneModelFilter = new PhoneModelFilter();
  fields = new PhoneModelFilter();

  phoneModels: Array<PhoneModel> = [];

  constructor(public phoneModelService: PhoneModelService) {
  }

  async ngOnInit(): Promise<void> {
    this.phoneModelService.getAll().subscribe(data => this.phoneModels = data);
    this.phoneModelService.getPhoneModelFilter().subscribe(data => {
      this.phoneModelFilter = data;
      this.fields.hasAudioOutput = null;
      this.fields.isMemoryCardSupported = null;
    });
  }

  getRamAndRomVariantsAsString(phoneModel: PhoneModel): string {
    return phoneModel.ramAndRomVariants.map(variant => `${StringConstants.RAM} ${variant.ramSizeInGb} ${StringConstants.GB} ${StringConstants.ROM} ${variant.romSizeInGb} ${StringConstants.GB}`).join(', ');
  }

}
