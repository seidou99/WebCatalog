import {Injectable} from '@angular/core';
import {BaseDataObjectService} from './base-data-object-service';
import {BaseDataObject} from '../model/base-data-object';
import {Constants} from '../Constants';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SimCardTypeService extends BaseDataObjectService<BaseDataObject> {

  apiUrl = Constants.SIM_CARD_TYPES_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }

}
