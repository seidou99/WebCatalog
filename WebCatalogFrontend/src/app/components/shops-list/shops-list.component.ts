import {Component, OnInit} from '@angular/core';
import {ShopService} from "../../services/shop.service";
import {BaseDataObjectWithName} from "../../model/base-data-object";

@Component({
  selector: 'app-shops-list',
  templateUrl: './shops-list.component.html',
  styleUrls: ['./shops-list.component.css']
})
export class ShopsListComponent implements OnInit {

  shops: Array<BaseDataObjectWithName> = [];

  constructor(protected shopService: ShopService) {
  }

  async ngOnInit(): Promise<void> {
    this.shops = await this.shopService.getAll().toPromise();
    console.log('shops', this.shops);
  }

}
