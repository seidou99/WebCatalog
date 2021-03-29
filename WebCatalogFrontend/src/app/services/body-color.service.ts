import {Injectable} from '@angular/core';
import {BaseDataObjectService} from './base-data-object-service';
import {BaseDataObject} from '../model/base-data-object';
import {Constants} from '../Constants';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BodyColorService extends BaseDataObjectService<BaseDataObject> {

  apiUrl = Constants.BODY_COLORS_API_URL;

  constructor(private http: HttpClient) {
    super(http);
  }
}
