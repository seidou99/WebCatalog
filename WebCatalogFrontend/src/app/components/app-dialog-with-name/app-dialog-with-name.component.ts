import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-app-dialog-with-name-and-description',
  templateUrl: './app-dialog-with-name.component.html',
  styleUrls: ['./app-dialog-with-name.component.css']
})
export class AppDialogWithNameComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data) {
  }

  public result = {name: ''};

  ngOnInit(): void {
  }

}
