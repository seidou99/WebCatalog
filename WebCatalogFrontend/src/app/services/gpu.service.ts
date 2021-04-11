import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest-service';
import {Gpu} from '../model/gpu';
import {ApiConstants} from '../Constants';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GpuService extends BaseDataObjectRestService<Gpu> {

  apiUrl = ApiConstants.FINGERPRINT_SCANNER_LOCATIONS_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }

  getAllMobileGpus(): Observable<Array<Gpu>> {
    return this.http.get<Array<Gpu>>(ApiConstants.MOBILE_GPUS_API_URL);
  }

}
