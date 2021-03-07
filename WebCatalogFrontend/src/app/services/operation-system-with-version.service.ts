import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Constants} from '../Constants';
import {OperationSystemWithVersion} from '../model/operation-system-with-version';

@Injectable({
  providedIn: 'root'
})
export class OperationSystemWithVersionService {

  constructor(public httpClient: HttpClient) {
  }

  getAll(): Observable<Array<OperationSystemWithVersion>> {
    return this.httpClient.get<Array<OperationSystemWithVersion>>(Constants.OPERATION_SYSTEMS_WITH_VERSIONS_API_URL);
  }

  save(operationSystemWithVersion: OperationSystemWithVersion): Observable<void> {
    return this.httpClient.post<void>(Constants.OPERATION_SYSTEMS_WITH_VERSIONS_API_URL, operationSystemWithVersion);
  }
}
