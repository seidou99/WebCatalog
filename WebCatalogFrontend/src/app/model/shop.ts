import {BaseDataObject} from "./base-data-object";
import {User} from "./User";

export class Shop extends BaseDataObject {
  name: string;
  addresses: Array<string>;
  contactInfoList: Array<string>;
  shopAdmin: User;
  shopDescription: string;
}
