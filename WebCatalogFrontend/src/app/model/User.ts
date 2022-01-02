import {BaseDataObject} from "./base-data-object";

export class User extends BaseDataObject {
  name: string;
  surname: string;
  email: string;
  roles: Array<any>;
}

export enum Role {
  USER = 'USER',
  APP_ADMIN = 'APP_ADMIN',
  SHOP_ADMIN = 'SHOP_ADMIN'
}

export enum SearchType {
  NAME_AND_SURNAME = 'NAME_AND_SURNAME',
  EMAIL = 'EMAIL'
}

