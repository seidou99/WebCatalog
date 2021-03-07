import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export class BaseDataObjectService<T> {

  apiUrl: string;

  constructor(public httpClient: HttpClient) {
  }

  getAll(): Observable<Array<T>> {
    return this.httpClient.get<Array<T>>(this.apiUrl);
  }

  save(entity: T): Observable<void> {
    return this.httpClient.post<void>(this.apiUrl, entity);
  }
}
