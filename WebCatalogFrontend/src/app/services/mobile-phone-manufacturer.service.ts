import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../components/Constants';
import {MobilePhoneManufacturer} from '../components/model/MobilePhoneManufacturer';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MobilePhoneManufacturerService {

  constructor(public httpClient: HttpClient) {
  }

  getAllPhoneManufacturers(): Observable<Array<MobilePhoneManufacturer>> {
    return this.httpClient.get<Array<MobilePhoneManufacturer>>(Constants.MOBILE_PHONE_MANUFACTURERS_API_URL);
  }
}
