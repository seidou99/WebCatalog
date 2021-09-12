import {Injectable} from '@angular/core';
import {Phone} from '../model/phone';
import {ApiConstants} from '../Constants';
import {HttpClient} from '@angular/common/http';
import {PhoneFilter} from '../model/phone-filter';
import {BaseDataObjectWithFilteringAndPaginationRestService} from './base-data-object-with-filtering-and-pagination-rest.service';

@Injectable({
  providedIn: 'root'
})
export class PhoneService extends BaseDataObjectWithFilteringAndPaginationRestService<Phone, PhoneFilter> {

  apiUrl = ApiConstants.PHONES_API_URL;
  filterApiUrl = ApiConstants.PHONES_FILTER_API_URL;
  filteredDtoApiUrl = ApiConstants.PHONES_FILTERED_API_URL;
  filteredDtoCountApiUrl = ApiConstants.PHONES_FILTERED_COUNT_API_URL;

  constructor(private http: HttpClient) {
    super(http);
  }
}
