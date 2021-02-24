import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-app-dialog-with-name-and-description',
  templateUrl: './app-dialog-with-name-and-description.component.html',
  styleUrls: ['./app-dialog-with-name-and-description.component.css']
})
export class AppDialogWithNameAndDescriptionComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data) {
  }

  public result = {title: '', description: ''};

  ngOnInit(): void {
  }

}
