import {BaseDataObjectRestService} from './base-data-object-rest.service';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

export class BaseDataObjectWithFilteringAndPaginationRestService<T, R> extends BaseDataObjectRestService<T> {

  filterApiUrl: string;
  filteredDtoApiUrl: string;
  filteredDtoCountApiUrl: string;

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }

  getFilterPossibleValues(): Observable<R> {
    return this.httpClient.get<R>(this.filterApiUrl);
  }

  getFilteredDataObjects(filter: R, pageIndex: number, pageSize: number): Observable<Array<T>> {
    return this.httpClient.post<Array<T>>(this.filteredDtoApiUrl, filter, {
      params: {
        pageIndex: `${pageIndex}`,
        pageSize: `${pageSize}`
      }
    });
  }

  getFilteredDataObjectsCount(filter: R): Observable<number> {
    return this.httpClient.post<number>(this.filteredDtoCountApiUrl, filter);
  }
}
