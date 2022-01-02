import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";
import {UtilService} from "../../services/util.service";
import {ApiConstants, FormControlNames, ValidationConstants} from "../../Constants";

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  FormControlNames = FormControlNames;
  hidePassword = true;
  hideConfirmPassword = true;
  form = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(20)]],
      surname: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(20)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.minLength(ValidationConstants.PASSWORD_MIN_LENGTH), Validators.maxLength(ValidationConstants.PASSWORD_MAX_LENGTH)]],
      confirmPassword: ['', [Validators.minLength(ValidationConstants.PASSWORD_MIN_LENGTH), Validators.maxLength(ValidationConstants.PASSWORD_MAX_LENGTH)]]
    }
  );

  constructor(protected userService: UserService, protected route: ActivatedRoute, protected router: Router, protected fb: FormBuilder, public util: UtilService) {
  }

  async ngOnInit(): Promise<void> {
    const userId = this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM);
    const user = await this.userService.getById(userId).toPromise();
    this.form.patchValue({
      name: user.name,
      surname: user.surname,
      email: user.email
    });
  }

  async save(): Promise<void> {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      this.form.markAsDirty();
      return;
    }
    const rawValue = this.form.getRawValue();
    if (rawValue.password !== rawValue.confirmPassword) {
      window.alert('Пароль и подтверждение пароля не совпадают');
      return;
    }
  }

}
