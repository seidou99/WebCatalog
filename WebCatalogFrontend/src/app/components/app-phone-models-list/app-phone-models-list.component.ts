import {Component, OnInit} from '@angular/core';
import {PhoneModelFilterService} from '../../services/phone-model-filter.service';
import {PhoneModelFilterVariants} from '../../model/phone-model-filter-variants';

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

  constructor(private phoneModelFilterService: PhoneModelFilterService) {
  }

  ngOnInit(): void {
  }

}
