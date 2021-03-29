import {Injectable} from '@angular/core';
import {BaseDataObjectService} from './base-data-object-service';
import {BaseDataObject} from '../model/base-data-object';
import {Constants} from '../Constants';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConnectionSocketService extends BaseDataObjectService<BaseDataObject> {

  apiUrl = Constants.CONNECTION_SOCKETS_API_URL;

  constructor(private http: HttpClient) {
    super(http);
  }
}
