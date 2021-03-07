import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Constants} from '../Constants';
import {OperationSystem} from '../model/operation-system';
import {OperationSystemWithVersion} from '../model/operation-system-with-version';

@Injectable({
  providedIn: 'root'
})
export class OperationSystemService {

  constructor(public httpClient: HttpClient) {
  }

  getAll(): Observable<Array<OperationSystem>> {
    return this.httpClient.get<Array<OperationSystem>>(Constants.OPERATION_SYSTEMS_API_URL);
  }

  save(operationSystem: OperationSystem | OperationSystemWithVersion): Observable<void> {
    return this.httpClient.post<void>(Constants.OPERATION_SYSTEMS_API_URL, operationSystem);
  }
}
