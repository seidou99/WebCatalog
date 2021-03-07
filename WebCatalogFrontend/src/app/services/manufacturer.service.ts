import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../Constants';
import {Manufacturer} from '../model/manufacturer';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ManufacturerService {

  constructor(public httpClient: HttpClient) {
  }

  getAll(): Observable<Array<Manufacturer>> {
    return this.httpClient.get<Array<Manufacturer>>(Constants.MANUFACTURERS_API_URL);
  }

  save(manufacturer: Manufacturer): Observable<void> {
    return this.httpClient.post<void>(Constants.MANUFACTURERS_API_URL, manufacturer);
  }
}
