import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/User';
import {ApiConstants} from '../Constants';
import {Observable} from 'rxjs';
import {LoginRequest} from "../model/login-request";
import {LoginResponse} from "../model/login-response";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(protected http: HttpClient) {
  }

  create(user: User): Observable<User> {
    return this.http.post<User>(ApiConstants.USERS_API_URL, user);
  }

  getById(id: string | number): Observable<User> {
    return this.http.get<User>(`${ApiConstants.USERS_API_URL}/${id}`);
  }

  deleteById(id: string | number): Observable<void> {
    return this.http.delete<void>(`${ApiConstants.USERS_API_URL}/${id}`);
  }

  getAll(): Observable<Array<User>> {
    return this.http.get<Array<User>>(ApiConstants.USERS_API_URL);
  }

  login(loginRequest: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(ApiConstants.LOGIN_API_URL, loginRequest);
  }

}
