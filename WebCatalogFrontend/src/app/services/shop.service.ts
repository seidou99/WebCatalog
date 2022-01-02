import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BaseDataObjectWithName} from "../model/base-data-object";
import {Observable} from "rxjs";
import {ApiConstants} from "../Constants";
import {Shop} from "../model/shop";

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  constructor(protected http: HttpClient) {
  }

  create(shop: BaseDataObjectWithName): Observable<BaseDataObjectWithName> {
    return this.http.post<BaseDataObjectWithName>(ApiConstants.SHOPS_API_URL, shop);
  }

  edit(shop: Shop): Observable<void> {
    return this.http.put<void>(ApiConstants.SHOPS_API_URL, shop);
  }

  getById(id: string | number): Observable<Shop> {
    return this.http.get<Shop>(`${ApiConstants.SHOPS_API_URL}/${id}`);
  }

  getAll(): Observable<Array<BaseDataObjectWithName>> {
    return this.http.get<Array<BaseDataObjectWithName>>(ApiConstants.SHOPS_API_URL);
  }

  deleteById(id: string | number): Observable<void> {
    return this.http.delete<void>(`${ApiConstants.SHOPS_API_URL}/${id}`);
  }
}
