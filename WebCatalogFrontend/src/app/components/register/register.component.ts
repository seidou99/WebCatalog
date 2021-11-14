import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {FormControlNames, ValidationConstants} from "../../Constants";
import {UtilService} from "../../services/util.service";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  hidePassword = true;
  hideConfirmPassword = true;
  FormControlNames = FormControlNames;
  form = this.fb.group({
    email: [null, [Validators.required, Validators.email]],
    password: [null, [Validators.required, Validators.minLength(ValidationConstants.PASSWORD_MIN_LENGTH), Validators.maxLength(ValidationConstants.PASSWORD_MAX_LENGTH)]],
    confirmPassword: [null, [Validators.required, Validators.minLength(ValidationConstants.PASSWORD_MIN_LENGTH), Validators.maxLength(ValidationConstants.PASSWORD_MAX_LENGTH), this.util.confirmPasswordValidator()]],
    name: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(20)]],
    surname: [null, [Validators.required, Validators.minLength(1), Validators.maxLength(20)]]
  });

  constructor(protected fb: FormBuilder, public util: UtilService, protected userService: UserService) {
  }

  ngOnInit(): void {
    this.form.get('password').statusChanges.subscribe(() => {
      this.form.get('confirmPassword').updateValueAndValidity();
    });
    this.form.get('password').valueChanges.subscribe(() => {
      this.form.get('confirmPassword').updateValueAndValidity();
    });
  }

  register(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      this.util.logFormValidationErrors(this.form);
      return;
    }
  }
}
