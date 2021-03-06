import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest-service';
import {BaseDataObject} from '../model/base-data-object';
import {ApiConstants} from '../Constants';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConnectionSocketService extends BaseDataObjectRestService<BaseDataObject> {

  apiUrl = ApiConstants.CONNECTION_SOCKETS_API_URL;

  constructor(private http: HttpClient) {
    super(http);
  }
}
