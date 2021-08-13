import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ApiConstants} from '../Constants';
import {OperationSystemWithVersion} from '../model/operation-system-with-version';
import {BaseDataObjectRestService} from './base-data-object-rest.service';

@Injectable({
  providedIn: 'root'
})
export class OperationSystemWithVersionService extends BaseDataObjectRestService<OperationSystemWithVersion> {

  apiUrl = ApiConstants.OPERATION_SYSTEMS_WITH_VERSIONS_API_URL;

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }
}
