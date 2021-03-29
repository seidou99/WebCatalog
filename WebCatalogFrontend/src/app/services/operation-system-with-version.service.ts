import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Constants} from '../Constants';
import {OperationSystemWithVersion} from '../model/operation-system-with-version';
import {BaseDataObjectService} from './base-data-object-service';

@Injectable({
  providedIn: 'root'
})
export class OperationSystemWithVersionService extends BaseDataObjectService<OperationSystemWithVersion> {

  apiUrl = Constants.OPERATION_SYSTEMS_WITH_VERSIONS_API_URL;

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }
}
