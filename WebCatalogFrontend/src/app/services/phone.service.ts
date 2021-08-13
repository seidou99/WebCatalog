import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest.service';
import {Phone} from '../model/phone';
import {ApiConstants} from '../Constants';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PhoneFilter} from '../model/phone-filter';

@Injectable({
  providedIn: 'root'
})
export class PhoneService extends BaseDataObjectRestService<Phone> {

  apiUrl = ApiConstants.PHONES_API_URL;

  constructor(private http: HttpClient) {
    super(http);
  }

  getPhoneFilterPossibleValues(): Observable<PhoneFilter> {
    return this.http.get<PhoneFilter>(ApiConstants.PHONES_API_URL);
  }
}
