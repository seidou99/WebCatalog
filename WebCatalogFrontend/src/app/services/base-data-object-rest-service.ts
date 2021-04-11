import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export class BaseDataObjectRestService<T> {

  apiUrl: string;

  constructor(public httpClient: HttpClient) {
  }

  getAll(): Observable<Array<T>> {
    return this.httpClient.get<Array<T>>(this.apiUrl);
  }

  getById(id: string | number): Observable<T> {
    return this.httpClient.get<T>(`${this.apiUrl}/${id}`);
  }

  save(entity: T): Observable<void> {
    return this.httpClient.post<void>(this.apiUrl, entity);
  }
}
