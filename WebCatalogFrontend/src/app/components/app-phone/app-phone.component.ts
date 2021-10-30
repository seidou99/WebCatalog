import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ApiConstants} from '../../Constants';
import {PhoneService} from '../../services/phone.service';
import {Phone} from '../../model/phone';
import {UtilService} from '../../services/util.service';
import {Image} from "../../model/base-data-object";
import {MatDialog} from "@angular/material/dialog";
import {YesOrNoDialogWithTitleComponent} from "../../yes-or-no-dialog-with-title/yes-or-no-dialog-with-title.component";

@Component({
  selector: 'app-app-phone',
  templateUrl: './app-phone.component.html',
  styleUrls: ['./app-phone.component.css']
})
export class AppPhoneComponent implements OnInit {

  phone: Phone;
  galleryBigImage: Image;

  constructor(public phoneService: PhoneService, public route: ActivatedRoute, public utilService: UtilService, public dialog: MatDialog, protected router: Router) {
  }

  async ngOnInit(): Promise<void> {
    const id = this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM);
    this.phone = await this.phoneService.getById(id).toPromise();
    console.log('phone', this.phone);
  }

  changeSelectedGalleryImage(image: Image): void {
    this.galleryBigImage = image;
  }

  async deletePhone(): Promise<void> {
    const dialogResult = await this.dialog.open(YesOrNoDialogWithTitleComponent, {
      width: '300px',
      data: {title: 'Точно удалить?'}
    }).afterClosed().toPromise() as boolean;
    if (dialogResult) {
      await this.phoneService.delete(this.phone.id).toPromise();
      this.router.navigate(['phones']);
    }
  }
}
