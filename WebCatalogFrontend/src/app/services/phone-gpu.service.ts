import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest.service';
import {MobileGpu} from '../model/mobileGpu';
import {ApiConstants} from '../Constants';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PhoneGpuService extends BaseDataObjectRestService<MobileGpu> {

  apiUrl = ApiConstants.FINGERPRINT_SCANNER_LOCATIONS_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }

  getAllMobileGpus(): Observable<Array<MobileGpu>> {
    return this.http.get<Array<MobileGpu>>(ApiConstants.PHONE_GPUS_API_URL);
  }

}
