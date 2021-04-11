import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest-service';
import {Cpu} from '../model/cpu';
import {HttpClient} from '@angular/common/http';
import {ApiConstants} from '../Constants';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CpuService extends BaseDataObjectRestService<Cpu> {

  apiUrl = ApiConstants.CPUS_API_URL;

  constructor(http: HttpClient) {
    super(http);
  }

  save(entity: Cpu): Observable<void> {
    return this.httpClient.post<void>(this.apiUrl, entity);
  }

}
