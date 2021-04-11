import {Component, OnInit} from '@angular/core';
import {PhoneModelFilterVariants} from '../../model/phone-model-filter-variants';
import {PhoneModelService} from "../../services/phone-model.service";
import {PhoneModel} from "../../model/phone-model";

@Component({
  selector: 'app-app-phone-models-list',
  templateUrl: './app-phone-models-list.component.html',
  styleUrls: ['./app-phone-models-list.component.css']
})
export class AppPhoneModelsListComponent implements OnInit {

  phoneModelFilterVariants = new PhoneModelFilterVariants();
  fields = {
    select: {
      manufacturer: [],
      marketLaunchYear: [],
      operationSystemWithVersion: [],
      screenDiagonalInInches: [],
      screenTechnology: [],
      screenRefreshRate: [],
      cameraInMp: [],
      simCardsAmount: [],
      simCardType: [],
      dustAndMoistureProtection: [],
      batteryCapacity: [],
      fingerprintScannerLocation: [],
      screenProtection: [],
      cpu: [],
      frontCamera: [],
      connectionSocket: [],
      length: [],
      width: [],
      thickness: [],
      weight: []
    },
    checkbox: {
      isMemoryCardSupported: false,
      is5GSupported: false,
      hasAudioProcessor: false,
      hasAudioOutput: false
    },
    screenResolution: [],
    ram: [],
    rom: [],
    coresAmount: [],
    cpuClockSpeed: [],
    techprocess: [],
    gpu: []
  };

  phoneModels: Array<PhoneModel> = [];

  constructor(public phoneModelService: PhoneModelService) {
  }

  async ngOnInit(): Promise<void> {
    this.phoneModels = await this.phoneModelService.getAll().toPromise();
    console.log('phone models');
    console.log(this.phoneModels);
  }

}
