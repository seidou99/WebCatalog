import {BaseDataObjectWithName} from "./base-data-object";

export class ManufacturerType extends BaseDataObjectWithName {
  public static readonly MOBILE_PHONE = new ManufacturerType('MOBILE_PHONE');


  constructor(name?: string) {
    super(name);
  }
}
