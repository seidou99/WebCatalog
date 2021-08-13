import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest.service';
import {BaseDataObjectWithName} from '../model/base-data-object';
import {HttpClient} from '@angular/common/http';
import {ApiConstants} from '../Constants';

@Injectable({
  providedIn: 'root'
})
export class FingerprintScannerLocationService extends BaseDataObjectRestService<BaseDataObjectWithName> {

  apiUrl = ApiConstants.FINGERPRINT_SCANNER_LOCATIONS_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }
}
