import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {AppDialogWithNameAndDescriptionComponent} from '../app-dialog-with-name-and-description/app-dialog-with-name-and-description.component';
import {MobilePhoneManufacturerService} from '../../services/mobile-phone-manufacturer.service';
import {Observable} from 'rxjs';
import {MobilePhoneManufacturer} from '../model/MobilePhoneManufacturer';

@Component({
  selector: 'app-new-phone-model',
  templateUrl: './new-phone-model.component.html',
  styleUrls: ['./new-phone-model.component.css']
})
export class NewPhoneModelComponent implements OnInit {
  constructor(public dialog: MatDialog, public manufacturerService: MobilePhoneManufacturerService) {
  }

  ramAndRomVariants: Array<number> = [1];
  manufacturers: Observable<Array<MobilePhoneManufacturer>>;

  ngOnInit(): void {
    this.manufacturers = this.manufacturerService.getAllPhoneManufacturers();
  }

  changeRamAndRomVariants($event: any): void {
    this.ramAndRomVariants = [];
    for (let i = 0; i < $event.target.value; i++) {
      this.ramAndRomVariants.push(i + 1);
    }
  }

  createNewManufacturer(): void {
    const dialogRef = this.dialog.open(AppDialogWithNameAndDescriptionComponent, {
      width: '600px',
      data: {formTitle: 'Создать нового производителя'}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
    });
  }

}
