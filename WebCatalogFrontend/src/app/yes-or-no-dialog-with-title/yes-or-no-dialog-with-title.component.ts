import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";

@Component({
  selector: 'app-yes-or-no-dialog-with-title',
  templateUrl: './yes-or-no-dialog-with-title.component.html',
  styleUrls: ['./yes-or-no-dialog-with-title.component.css']
})
export class YesOrNoDialogWithTitleComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data) { }

  ngOnInit(): void {
  }

}
