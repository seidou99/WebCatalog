import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../Constants';
import {Manufacturer} from '../model/manufacturer';
import {Observable} from 'rxjs';
import {BaseDataObjectService} from './base-data-object-service';

@Injectable({
  providedIn: 'root'
})
export class ManufacturerService extends BaseDataObjectService<Manufacturer> {

  apiUrl = Constants.MANUFACTURERS_API_URL;

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }
}
