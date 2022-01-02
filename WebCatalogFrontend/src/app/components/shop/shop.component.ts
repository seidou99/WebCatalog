import {Component, OnInit} from '@angular/core';
import {ShopService} from "../../services/shop.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ApiConstants} from "../../Constants";
import {Shop} from "../../model/shop";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  shop: Shop;

  constructor(protected shopService: ShopService, protected route: ActivatedRoute, protected router: Router) {
  }

  async ngOnInit(): Promise<void> {
    this.shop = await this.shopService.getById(this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM)).toPromise();
    console.log('shop', this.shop);
  }

  getAllContactInfo(): string {
    let result = '';
    if (this.shop !== null && this.shop !== undefined && this.shop.contactInfoList !== null && this.shop.contactInfoList !== undefined) {
      result = this.shop.contactInfoList.join(', ');
    }
    return result;
  }

  getAllAddresses(): string {
    let result = '';
    if (this.shop !== null && this.shop !== undefined && this.shop.addresses !== null && this.shop.addresses !== undefined) {
      result = this.shop.addresses.join(', ');
    }
    return result;
  }

  async delete(): Promise<void> {
    await this.shopService.deleteById(this.shop.id).toPromise();
    await this.router.navigate(['shops']);
  }

}
