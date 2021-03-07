import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../Constants';
import {ScreenTechnology} from '../model/screen-technology';
import {BaseDataObjectService} from "./base-data-object-service";

@Injectable({
  providedIn: 'root'
})
export class ScreenTechnologyService extends BaseDataObjectService<ScreenTechnology> {

  apiUrl = Constants.SCREEN_TECHNOLOGIES_API_URL;

  constructor(public httpClient: HttpClient) {
    super(httpClient);
  }
}
