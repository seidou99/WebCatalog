import {MobileGpu} from './mobileGpu';
import {BaseDataObjectWithName} from './base-data-object';

export class MobileCpu extends BaseDataObjectWithName {

  clockSpeedImMHz: number;
  integratedGpu: MobileGpu;
  coresBlocks: Array<MobileCpuCoresBlock> = [];
  digitalCapacityInBits: number;
  techprocessInNm: number;
}

export class MobileCpuCoresBlock extends BaseDataObjectWithName{
  coresAmount: number;
  clockSpeedInMHz: number;
}
