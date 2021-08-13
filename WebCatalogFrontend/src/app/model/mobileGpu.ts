import {BaseDataObjectWithName} from './base-data-object';

export class MobileGpu extends BaseDataObjectWithName {
  clockSpeedInMHz: number;

  constructor(name: string, clockSpeedInMHz: number) {
    super();
    this.name = name;
    this.clockSpeedInMHz = clockSpeedInMHz;
  }

}
