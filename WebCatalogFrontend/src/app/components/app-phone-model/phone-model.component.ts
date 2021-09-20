import {Component, OnInit} from '@angular/core';
import {PhoneModelService} from '../../services/phone-model.service';
import {PhoneModel} from '../../model/phone-model';
import {ActivatedRoute} from '@angular/router';
import {ApiConstants, StringConstants} from '../../Constants';
import {Image} from '../../model/base-data-object';

@Component({
  selector: 'app-phone',
  templateUrl: './phone-model.component.html',
  styleUrls: ['./phone-model.component.css']
})
export class PhoneModelComponent implements OnInit {

  phoneModel: PhoneModel;
  galleryBigImage: Image;

  constructor(public phoneModelService: PhoneModelService, public route: ActivatedRoute) {
  }

  async ngOnInit(): Promise<void> {
    const id = this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM);
    this.phoneModel = await this.phoneModelService.getById(id).toPromise();
    console.log(this.phoneModel);
  }

  getCpuCoresAsString(): string {
    if (!this.phoneModel) {
      return '';
    }
    const cores = this.phoneModel.cpu.coresBlocks.map(value => value.coresAmount);
    const coresAmount = cores.reduce((previousValue, currentValue) => previousValue + currentValue);
    let result = '' + coresAmount;
    if (cores.length > 1) {
      result += ` (${cores.join('+')})`;
    }
    return result;
  }

  getCpuMicroarchitectureAsString(): string {
    if (!this.phoneModel) {
      return '';
    }
    return this.phoneModel.cpu.coresBlocks.map(coresBlock => `${coresBlock.name} ${coresBlock.clockSpeedInMHz}`).join(' + ');
  }

  getScreenPpi(): number {
    if (!this.phoneModel) {
      return null;
    }
    const diagonalInPx = Math.sqrt(Math.pow(this.phoneModel.horizontalScreenResolution, 2) +
      Math.pow(this.phoneModel.verticalScreenResolution, 2));
    return Math.trunc(diagonalInPx / this.phoneModel.screenDiagonalInInches);
  }

  getRamAndRomVariantsAsString(): string {
    if (!this.phoneModel) {
      return null;
    }
    return this.phoneModel.ramAndRomVariants.map(variant => `${StringConstants.RAM} ${variant.ramSizeInGb} ${StringConstants.GB} ${StringConstants.ROM} ${variant.romSizeInGb} ${StringConstants.GB}`).join(', ');
  }

  getCpuClockSpeed(): number {
    if (!this.phoneModel) {
      return null;
    }
    const clockSpeeds = this.phoneModel.cpu.coresBlocks.map(block => block.clockSpeedInMHz);
    let maxClockSpeed = clockSpeeds[0];
    for (let i = 1; i < clockSpeeds.length; i++) {
      if (clockSpeeds[i] > maxClockSpeed) {
        maxClockSpeed = clockSpeeds[i];
      }
    }
    return maxClockSpeed;
  }

  changeSelectedGalleryImage(image: Image): void {
    this.galleryBigImage = image;
  }

  // TODO добавить фронтальную камеру, которую где-то проебали

}
