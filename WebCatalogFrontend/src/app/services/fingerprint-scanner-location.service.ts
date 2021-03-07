import {Injectable} from '@angular/core';
import {BaseDataObjectService} from './base-data-object-service';
import {BaseDataObject} from '../model/base-data-object';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../Constants';

@Injectable({
  providedIn: 'root'
})
export class FingerprintScannerLocationService extends BaseDataObjectService<BaseDataObject> {

  apiUrl = Constants.FINGERPRINT_SCANNER_LOCATIONS_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }
}
