import {Component, OnInit} from '@angular/core';
import {PhoneModelFilter} from '../../model/phone-model-filter';
import {PhoneModelService} from '../../services/phone-model.service';
import {PhoneModel} from '../../model/phone-model';
import {PageEvent} from '@angular/material/paginator';
import {UtilService} from '../../services/util.service';

@Component({
  selector: 'app-app-phone-models-list',
  templateUrl: './app-phone-models-list.component.html',
  styleUrls: ['./app-phone-models-list.component.css']
})
export class AppPhoneModelsListComponent implements OnInit {

  phoneModelFilterPossibleValues = new PhoneModelFilter();
  filterFields = new PhoneModelFilter();
  phoneModels: Array<PhoneModel> = [];
  phoneModelsCount = 0;
  pageSize = 10;
  pageSizeOptions = [10, 25, 50, 100];
  pageIndex = 0;

  constructor(public phoneModelService: PhoneModelService, public utilService: UtilService) {
  }

  async ngOnInit(): Promise<void> {
    console.log('filter fields');
    console.log(this.filterFields);
    this.loadFilteredPhoneModels();
    this.phoneModelService.getFilterPossibleValues().subscribe(data => {
      this.phoneModelFilterPossibleValues = data;
    });
  }

  onPageChanged($event: PageEvent): void {
    this.pageSize = $event.pageSize;
    this.pageIndex = $event.pageIndex;
    console.log('page changed');
    this.loadFilteredPhoneModels();
  }

  loadFilteredPhoneModels(): void {
    this.phoneModelService.getFilteredDataObjects(this.filterFields, this.pageIndex, this.pageSize).subscribe(data => {
      this.phoneModels = data;
    });
    this.phoneModelService.getFilteredDataObjectsCount(this.filterFields).subscribe(data => {
      this.phoneModelsCount = data;
      console.log('count of filtered phone models', this.phoneModelsCount);
    });
  }

}
