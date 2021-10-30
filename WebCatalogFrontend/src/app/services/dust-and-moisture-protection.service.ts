import {Injectable} from '@angular/core';
import {BaseDataObjectRestService} from './base-data-object-rest.service';
import {BaseDataObjectWithName} from '../model/base-data-object';
import {ApiConstants} from '../Constants';
import {HttpClient} from '@angular/common/http';
import {DustAndMoistureProtection} from "../model/dust-and-moisture-protection";

@Injectable({
  providedIn: 'root'
})
export class DustAndMoistureProtectionService extends BaseDataObjectRestService<DustAndMoistureProtection> {

  apiUrl = ApiConstants.DUST_AND_MOISTURE_PROTECTION_API_URL;

  constructor(public http: HttpClient) {
    super(http);
  }
}
