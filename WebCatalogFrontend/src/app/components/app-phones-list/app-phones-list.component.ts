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
  phoneModelsCount = 0;
  pageSize = 10;
  pageSizeOptions = [10, 25, 50, 100];
  pageIndex = 0;

  constructor(public phoneService: PhoneService) {
  }

  async ngOnInit(): Promise<void> {
    this.phoneService.getPhoneFilterPossibleValues().subscribe(data => this.phoneFilterPossibleValues = data);
    this.phoneService.getAll().subscribe(data => this.phones = data);
  }

  onPageChanged($event: PageEvent): void {
    this.pageSize = $event.pageSize;
    this.pageIndex = $event.pageIndex;
    console.log('page changed');
    this.loadFilteredPhoneModels();
  }

  loadFilteredPhoneModels(): void {

  }

}
