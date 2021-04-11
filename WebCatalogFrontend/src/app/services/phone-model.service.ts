import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest-service';
import {PhoneModel} from '../model/phone-model';
import {HttpClient} from '@angular/common/http';
import {ApiConstants} from '../Constants';

@Injectable({
  providedIn: 'root'
})
export class PhoneModelService extends BaseDataObjectRestService<PhoneModel> {

  apiUrl = ApiConstants.PHONE_MODELS_API_URL;

  constructor(private http: HttpClient) {
    super(http);
  }
}
