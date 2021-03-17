import {BaseDataObject} from "./base-data-object";
import {Manufacturer} from "./manufacturer";

export class MobilePhoneModel extends BaseDataObject {

  manufacturer: Manufacturer;
  marketLaunchDate: Date;
  mobilePhoneType: MobilePhoneType;

}

export enum MobilePhoneType {

  SMARTPHONE = 'SMARTPHONE', SIMPLE_MOBILE_PHONE = 'SIMPLE_MOBILE_PHONE'
}
