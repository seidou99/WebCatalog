import {Component, OnInit} from '@angular/core';
import {ShopService} from "../../services/shop.service";
import {MatDialog} from "@angular/material/dialog";
import {AppDialogWithNameComponent} from "../app-dialog-with-name/app-dialog-with-name.component";
import {BaseDataObjectWithName} from "../../model/base-data-object";

@Component({
  selector: 'app-app-home-page',
  templateUrl: './app-home-page.component.html',
  styleUrls: ['./app-home-page.component.css']
})
export class AppHomePageComponent implements OnInit {

  constructor(protected shopService: ShopService, protected dialog: MatDialog) {
  }

  ngOnInit(): void {
  }

  async createShop(): Promise<void> {
    const shop = await this.dialog.open(AppDialogWithNameComponent, {
      width: '600px',
      data: {
        formTitle: 'Создать новый магазин'
      }
    }).afterClosed().toPromise() as BaseDataObjectWithName;
    if (shop != null) {
      const createdShop = await this.shopService.create(shop).toPromise();
      console.log('created shop', createdShop);
    }
  }

}
