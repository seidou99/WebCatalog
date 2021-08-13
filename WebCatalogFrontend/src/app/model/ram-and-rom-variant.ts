import {BaseDataObjectWithName} from './base-data-object';

export class RamAndRomVariant extends BaseDataObjectWithName {

  ramSizeInGb: number;
  romSizeInGb: number;


  constructor(ramSizeInGb: number, romSizeInGb: number) {
    super();
    this.ramSizeInGb = ramSizeInGb;
    this.romSizeInGb = romSizeInGb;
  }
}
