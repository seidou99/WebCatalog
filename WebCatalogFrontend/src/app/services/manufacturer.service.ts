import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ApiConstants} from '../Constants';
import {Manufacturer} from '../model/manufacturer';
import {Observable} from 'rxjs';
import {BaseDataObjectRestService} from './base-data-object-rest-service';

@Injectable({
  providedIn: 'root'
})
export class ManufacturerService extends BaseDataObjectRestService<Manufacturer> {

  apiUrl = ApiConstants.MANUFACTURERS_API_URL;

  constructor(public httpClient: HttpClient) {

    super(httpClient);
  }
}
