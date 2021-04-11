import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseDataObjectRestService} from './base-data-object-rest-service';
import {BaseDataObject} from '../model/base-data-object';
import {ApiConstants} from '../Constants';

@Injectable({
  providedIn: 'root'
})
export class ScreenProtectionService extends BaseDataObjectRestService<BaseDataObject> {

  apiUrl = ApiConstants.SCREEN_PROTECTIONS_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }
}
