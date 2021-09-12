import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog} from '@angular/material/dialog';
import {OperationSystem} from '../../model/operation-system';
import {AppDialogWithNameComponent} from '../app-dialog-with-name/app-dialog-with-name.component';
import {OperationSystemService} from '../../services/operation-system.service';
import {OperationSystemWithVersion} from '../../model/operation-system-with-version';

@Component({
  selector: 'app-app-new-operation-system-with-version-dialog',
  templateUrl: './app-new-operation-system-with-version-dialog.component.html',
  styleUrls: ['./app-new-operation-system-with-version-dialog.component.css']
})
export class AppNewOperationSystemWithVersionDialogComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data, public dialog: MatDialog,
              public operationSystemService: OperationSystemService) {
  }

  operationSystems: Array<OperationSystem> = [];
  public result = new OperationSystemWithVersion();

  async ngOnInit(): Promise<null> {
    this.operationSystems = await this.operationSystemService.getAll().toPromise();
    return new Promise(null);
  }

  async createNewOperationSystem(): Promise<void> {
    const dialogRef = this.dialog.open(AppDialogWithNameComponent, {
      width: '600px',
      data: {formTitle: 'Создать новую операционную систему'}
    });
    const operationSystem: OperationSystem = await dialogRef.afterClosed().toPromise();
    if (operationSystem === undefined) {
      return;
    }
    this.result.operationSystem = operationSystem;
    this.result.operationSystem.type = this.data.operationSystemType;
    this.operationSystems.push(operationSystem);
  }

}
