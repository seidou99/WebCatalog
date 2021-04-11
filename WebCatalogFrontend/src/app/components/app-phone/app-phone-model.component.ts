import {Component, OnInit} from '@angular/core';
import {PhoneModelService} from "../../services/phone-model.service";
import {PhoneModel} from "../../model/phone-model";
import {ActivatedRoute} from "@angular/router";
import {ApiConstants} from "../../Constants";

@Component({
  selector: 'app-app-phone',
  templateUrl: './app-phone-model.component.html',
  styleUrls: ['./app-phone-model.component.css']
})
export class AppPhoneModelComponent implements OnInit {

  phoneModel: PhoneModel;

  constructor(public phoneModelService: PhoneModelService, public route: ActivatedRoute) {
  }

  async ngOnInit(): Promise<void> {
    const id = this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM);
    this.phoneModel = await this.phoneModelService.getById(id).toPromise();
  }

  getCpuCoresAsString(): string {
    const cores = this.phoneModel.cpu.coresBlocks.map(value => value.coresAmount);
    const coresAmount = cores.reduce((previousValue, currentValue) => previousValue + currentValue);
    const coresArchitecture = cores.join('+');
    return `${coresAmount}(${coresArchitecture})`;
  }

  getCpuMicroarchitectureAsString(): string {
    return this.phoneModel.cpu.coresBlocks.map(coresBlock => `${coresBlock.name} ${coresBlock.clockSpeedInMHz}`).join(' + ');
  }

  getScreenPpi(): number {
    const diagonalInPx = Math.sqrt(Math.pow(this.phoneModel.horizontalScreenResolution, 2) + Math.pow(this.phoneModel.verticalScreenResolution, 2));
    return Math.trunc(diagonalInPx / this.phoneModel.screenDiagonalInInches);
  }

}
