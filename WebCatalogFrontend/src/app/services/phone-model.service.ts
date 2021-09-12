import {Injectable} from '@angular/core';
import {PhoneModel} from '../model/phone-model';
import {HttpClient} from '@angular/common/http';
import {ApiConstants} from '../Constants';
import {PhoneModelFilter} from '../model/phone-model-filter';
import {BaseDataObjectWithFilteringAndPaginationRestService} from './base-data-object-with-filtering-and-pagination-rest.service';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PhoneModelService extends BaseDataObjectWithFilteringAndPaginationRestService<PhoneModel, PhoneModelFilter> {

  apiUrl = ApiConstants.PHONE_MODELS_API_URL;
  filterApiUrl = ApiConstants.PHONE_MODELS_FILTER_API_URL;
  filteredDtoApiUrl = ApiConstants.PHONE_MODELS_FILTERED_API_URL;
  filteredDtoCountApiUrl = ApiConstants.PHONE_MODELS_FILTERED_COUNT_API_URL;

  constructor(private http: HttpClient) {
    super(http);
  }

  send(data: FormData): Observable<void> {
    return this.http.post<void>(this.apiUrl, data);
  }
}
