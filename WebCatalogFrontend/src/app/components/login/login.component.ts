import {Component, OnInit} from '@angular/core';
import {FormControlNames, ValidationConstants} from 'src/app/Constants';
import {FormBuilder, Validators} from "@angular/forms";
import {UtilService} from "../../services/util.service";
import {UserService} from "../../services/user.service";
import {LoginRequest} from "../../model/login-request";
import {LocalStorageService} from "../../services/local-storage.service";
import {LoginResponse} from "../../model/login-response";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hidePassword = true;
  FormControlNames = FormControlNames;
  form = this.fb.group({
    email: [null, [Validators.required, Validators.email]],
    password: [null, [Validators.required, Validators.minLength(ValidationConstants.PASSWORD_MIN_LENGTH), Validators.maxLength(ValidationConstants.PASSWORD_MAX_LENGTH)]]
  });

  constructor(protected fb: FormBuilder, public util: UtilService, protected userService: UserService, protected localStorageService: LocalStorageService, protected router: Router) {
  }

  ngOnInit(): void {
  }

  async login(): Promise<void> {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      // this.util.logFormValidationErrors(this.form);
      return;
    }
    const rawValue = this.form.getRawValue() as LoginRequest;
    // console.log('raw value', rawValue);
    const loginResponse = await this.userService.login(rawValue).toPromise() as LoginResponse;
    this.localStorageService.storeLoginResponse(loginResponse);
    this.router.navigate(['phones']);
  }

}
