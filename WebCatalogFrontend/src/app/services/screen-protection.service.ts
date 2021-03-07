import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaseDataObjectService} from './base-data-object-service';
import {BaseDataObject} from '../model/base-data-object';
import {Constants} from '../Constants';

@Injectable({
  providedIn: 'root'
})
export class ScreenProtectionService extends BaseDataObjectService<BaseDataObject> {

  apiUrl = Constants.SCREEN_PROTECTIONS_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }
}
