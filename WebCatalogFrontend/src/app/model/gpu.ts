import {BaseDataObject} from "./base-data-object";

export class Gpu extends BaseDataObject {
  isIntegrated: boolean;
  gpuType: GpuType;
  streamingProcessorsAmount: number;
  clockSpeedInMHz: number;
}

export enum GpuType {

  MOBILE = 'MOBILE', NOTEBOOK = 'NOTEBOOK', DESKTOP = 'DESKTOP'
}
