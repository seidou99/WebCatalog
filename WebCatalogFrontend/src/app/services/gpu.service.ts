import {Injectable} from '@angular/core';
import {BaseDataObjectService} from './base-data-object-service';
import {Gpu} from '../model/gpu';
import {Constants} from '../Constants';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GpuService extends BaseDataObjectService<Gpu> {

  apiUrl = Constants.FINGERPRINT_SCANNER_LOCATIONS_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }

  getAllMobileGpus(): Observable<Array<Gpu>> {
    return this.http.get<Array<Gpu>>(Constants.MOBILE_GPUS_API_URL);
  }

}
