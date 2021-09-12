import {Component, OnInit} from '@angular/core';
import {PhoneService} from '../../services/phone.service';
import {Phone} from '../../model/phone';
import {PhoneFilter} from '../../model/phone-filter';
import {PageEvent} from "@angular/material/paginator";

@Component({
  selector: 'app-app-phones-list',
  templateUrl: './app-phones-list.component.html',
  styleUrls: ['./app-phones-list.component.css']
})
export class AppPhonesListComponent implements OnInit {

  phones: Array<Phone> = [];
  phoneFilter = new PhoneFilter();
  phoneFilterPossibleValues = new PhoneFilter();
  phonesCount = 0;
  pageSize = 10;
  pageSizeOptions = [10, 25, 50, 100];
  pageIndex = 0;

  constructor(public phoneService: PhoneService) {
  }

  async ngOnInit(): Promise<void> {
    this.loadFilteredPhones();
    this.phoneService.getFilterPossibleValues().subscribe(data => {
      this.phoneFilterPossibleValues = data;
      console.log(this.phoneFilterPossibleValues);
    });
  }

  onPageChanged($event: PageEvent): void {
    this.pageSize = $event.pageSize;
    this.pageIndex = $event.pageIndex;
    console.log('page changed');
    this.loadFilteredPhones();
  }

  loadFilteredPhones(): void {
    this.phoneService.getFilteredDataObjects(this.phoneFilter, this.pageIndex, this.pageSize).subscribe(data => this.phones = data);
    this.phoneService.getFilteredDataObjectsCount(this.phoneFilter).subscribe(data => this.phonesCount = data);
  }

}
