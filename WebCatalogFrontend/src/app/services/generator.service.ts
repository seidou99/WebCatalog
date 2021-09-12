import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class GeneratorService {

  constructor(public http: HttpClient) {
  }

  public get(path: string): Observable<void> {
    return this.http.get<void>(path);
  }
}
