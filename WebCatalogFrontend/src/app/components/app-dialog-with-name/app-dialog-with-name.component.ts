import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-app-dialog-with-name-and-description',
  templateUrl: './app-dialog-with-name.component.html',
  styleUrls: ['./app-dialog-with-name.component.css']
})
export class AppDialogWithNameComponent implements OnInit {

  nameFormGroup: FormGroup;

  constructor(@Inject(MAT_DIALOG_DATA) public data, public fb: FormBuilder) {
    this.nameFormGroup = this.fb.group({
      result: [null, [Validators.required, Validators.minLength(1)]]
    });
  }

  getResult(): any {
    return {name: this.nameFormGroup.getRawValue().result};
  }

  ngOnInit(): void {
  }

}
