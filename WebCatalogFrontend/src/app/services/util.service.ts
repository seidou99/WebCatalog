import {Injectable} from '@angular/core';
import {PhoneModel} from "../model/phone-model";
import {StringConstants} from "../Constants";
import {Phone} from "../model/phone";

@Injectable({
  providedIn: 'root'
})
export class UtilService {

  getRamAndRomVariantsAsStringForPhoneModel(phoneModel: PhoneModel): string {
    return phoneModel.ramAndRomVariants.map(variant => `${StringConstants.RAM} ${variant.ramSizeInGb} ${StringConstants.GB} ${StringConstants.ROM} ${variant.romSizeInGb} ${StringConstants.GB}`).join(', ');
  }

  getCpuCoresAsStringForPhone(phone: Phone): string {
    if (!phone) {
      return '';
    }
    const cores = phone.phoneModel.cpu.coresBlocks.map(value => value.coresAmount);
    const coresAmount = cores.reduce((previousValue, currentValue) => previousValue + currentValue);
    let result = '' + coresAmount;
    if (cores.length > 1) {
      result += ` (${cores.join('+')})`;
    }
    return result;
  }

  getCpuMicroarchitectureAsStringForPhone(phone: Phone): string {
    if (!phone) {
      return '';
    }
    return phone.phoneModel.cpu.coresBlocks.map(coresBlock =>
      `${coresBlock.name} (${coresBlock.clockSpeedInMHz} ${StringConstants.MHz})`
    ).join(' + ');
  }

  getScreenPpiForPhone(phone: Phone): number {
    if (!phone) {
      return null;
    }
    const diagonalInPx = Math.sqrt(Math.pow(phone.phoneModel.horizontalScreenResolution, 2) +
      Math.pow(phone.phoneModel.verticalScreenResolution, 2));
    return Math.trunc(diagonalInPx / phone.phoneModel.screenDiagonalInInches);
  }

  getCpuClockSpeedForPhone(phone: Phone): number {
    if (!phone) {
      return null;
    }
    const clockSpeeds = phone.phoneModel.cpu.coresBlocks.map(block => block.clockSpeedInMHz);
    let maxClockSpeed = clockSpeeds[0];
    for (let i = 1; i < clockSpeeds.length; i++) {
      if (clockSpeeds[i] > maxClockSpeed) {
        maxClockSpeed = clockSpeeds[i];
      }
    }
    return maxClockSpeed;
  }
}
