import {PhoneModel} from './phone-model';
import {BaseDataObjectWithName} from './base-data-object';
import {RamAndRomVariant} from './ram-and-rom-variant';

export class Phone extends BaseDataObjectWithName{

  phoneModel: PhoneModel;
  color: BaseDataObjectWithName;
  ramAndRomVariant: RamAndRomVariant;
}
