import {Injectable} from '@angular/core';
import {LoginResponse} from "../model/login-response";
import {LocalStorageConstants} from "../Constants";

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  constructor() {
  }

  storeLoginResponse(data: LoginResponse): void {
    localStorage.setItem(LocalStorageConstants.EMAIL, data.email);
    localStorage.setItem(LocalStorageConstants.JWT, data.jwt);
    localStorage.setItem(LocalStorageConstants.NAME, data.name);
    localStorage.setItem(LocalStorageConstants.ROLES, JSON.stringify(data.roles));
    localStorage.setItem(LocalStorageConstants.SURNAME, data.surname);
    localStorage.setItem(LocalStorageConstants.USER_ID, data.userId.toString());
  }

  logout(): void {
    LocalStorageConstants.USER_DATA_FIELDS.forEach(v => localStorage.removeItem(v));
  }

  isLoggedIn(): boolean {
    return localStorage.getItem(LocalStorageConstants.JWT) !== null;
  }

  getJwt(): string {
    return localStorage.getItem(LocalStorageConstants.JWT);
  }

  getNameAndSurname(): string {
    return localStorage.getItem(LocalStorageConstants.NAME) + ' ' + localStorage.getItem(LocalStorageConstants.SURNAME);
  }

  getUserId(): string {
    return localStorage.getItem(LocalStorageConstants.USER_ID);
  }

  getRoles(): Array<string> {
    return JSON.parse(localStorage.getItem(LocalStorageConstants.ROLES));
  }
}
