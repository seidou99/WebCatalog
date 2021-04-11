import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ApiConstants} from '../Constants';
import {ScreenTechnology} from '../model/screen-technology';
import {BaseDataObjectRestService} from "./base-data-object-rest-service";

@Injectable({
  providedIn: 'root'
})
export class ScreenTechnologyService extends BaseDataObjectRestService<ScreenTechnology> {

  apiUrl = ApiConstants.SCREEN_TECHNOLOGIES_API_URL;

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }
}
