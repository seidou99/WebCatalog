import {Gpu} from './gpu';
import {BaseDataObject} from './base-data-object';

export class Cpu extends BaseDataObject {

  clockSpeedImMHz: number;
  integratedGpu: Gpu;
  coresBlocks: Array<CpuCoresBlock> = [];
  digitalCapacityInBits: number;
  techprocessInNm: number;
}

export class CpuCoresBlock extends BaseDataObject{
  coresAmount: number;
  clockSpeedInMHz: number;
}

export enum CpuType {

  MOBILE = 'MOBILE', DESKTOP = 'DESKTOP', NOTEBOOK = 'NOTEBOOK'
}
