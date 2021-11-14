import {Component, OnInit} from '@angular/core';
import {ShopService} from "../../services/shop.service";
import {BaseDataObjectWithName} from "../../model/base-data-object";
import {ActivatedRoute} from "@angular/router";
import {ApiConstants} from "../../Constants";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  shop: BaseDataObjectWithName;

  constructor(protected shopService: ShopService, protected route: ActivatedRoute) {
  }

  async ngOnInit(): Promise<void> {
    this.shop = await this.shopService.getById(this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM)).toPromise();
    console.log('shop', this.shop);
  }

}
