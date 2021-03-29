import {Injectable} from '@angular/core';
import {BaseDataObjectService} from './base-data-object-service';
import {MobilePhoneModel} from '../model/mobile-phone-model';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../Constants';

@Injectable({
  providedIn: 'root'
})
export class MobilePhoneModelService extends BaseDataObjectService<MobilePhoneModel> {

  apiUrl = Constants.MOBILE_PHONE_MODELS_API_URL;

  constructor(private http: HttpClient) {
    super(http);
  }
}
