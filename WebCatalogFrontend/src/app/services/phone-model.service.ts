import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest-service';
import {PhoneModel} from '../model/phone-model';
import {HttpClient} from '@angular/common/http';
import {ApiConstants} from '../Constants';
import {PhoneModelFilter} from "../model/phone-model-filter";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PhoneModelService extends BaseDataObjectRestService<PhoneModel> {

  apiUrl = ApiConstants.PHONE_MODELS_API_URL;

  constructor(private http: HttpClient) {
    super(http);
  }

  getPhoneModelFilter(): Observable<PhoneModelFilter> {
    return this.http.get<PhoneModelFilter>(ApiConstants.PHONE_MODELS_FILTER_API_URL);
  }

  getPhoneModelsFiltered(filter: PhoneModelFilter): Observable<Array<PhoneModel>> {
    return this.http.post<Array<PhoneModel>>(ApiConstants.PHONE_MODELS_FILTERED_API_URL, filter);
  }
}
