import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ApiConstants} from '../../Constants';
import {PhoneService} from '../../services/phone.service';
import {Phone} from '../../model/phone';
import {UtilService} from '../../services/util.service';
import {Image} from "../../model/base-data-object";

@Component({
  selector: 'app-app-phone',
  templateUrl: './app-phone.component.html',
  styleUrls: ['./app-phone.component.css']
})
export class AppPhoneComponent implements OnInit {

  phone: Phone;
  galleryBigImage: Image;

  constructor(public phoneService: PhoneService, public route: ActivatedRoute, public utilService: UtilService) {
  }

  async ngOnInit(): Promise<void> {
    const id = this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM);
    this.phone = await this.phoneService.getById(id).toPromise();
    console.log('phone');
    console.log(this.phone);
  }

  changeSelectedGalleryImage(image: Image): void {
    this.galleryBigImage = image;
  }

}
