import {BaseDataObject} from './base-data-object';

export class RamAndRomVariant extends BaseDataObject {

  ramSizeInGb: number;
  romSizeInGb: number;


  constructor(ramSizeInGb: number, romSizeInGb: number) {
    super();
    this.ramSizeInGb = ramSizeInGb;
    this.romSizeInGb = romSizeInGb;
  }
}
