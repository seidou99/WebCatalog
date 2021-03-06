import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest-service';
import {BaseDataObject} from '../model/base-data-object';
import {HttpClient} from '@angular/common/http';
import {ApiConstants} from '../Constants';

@Injectable({
  providedIn: 'root'
})
export class FingerprintScannerLocationService extends BaseDataObjectRestService<BaseDataObject> {

  apiUrl = ApiConstants.FINGERPRINT_SCANNER_LOCATIONS_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }
}
