import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest-service';
import {BaseDataObject} from '../model/base-data-object';
import {ApiConstants} from '../Constants';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SimCardTypeService extends BaseDataObjectRestService<BaseDataObject> {

  apiUrl = ApiConstants.SIM_CARD_TYPES_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }

}
