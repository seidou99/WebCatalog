import {BaseDataObjectWithName} from './base-data-object';
import {ManufacturerType} from './manufacturer-type';

export class Manufacturer extends BaseDataObjectWithName {

  manufacturerType: ManufacturerType;
}
