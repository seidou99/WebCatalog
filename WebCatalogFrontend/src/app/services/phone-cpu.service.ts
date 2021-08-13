import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest.service';
import {MobileCpu} from '../model/mobileCpu';
import {HttpClient} from '@angular/common/http';
import {ApiConstants} from '../Constants';

@Injectable({
  providedIn: 'root'
})
export class PhoneCpuService extends BaseDataObjectRestService<MobileCpu> {

  apiUrl = ApiConstants.PHONE_CPUS_API_URL;

  constructor(http: HttpClient) {
    super(http);
  }

}
