import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog} from '@angular/material/dialog';
import {MobileGpu} from '../../model/mobileGpu';
import {PhoneGpuService} from '../../services/phone-gpu.service';
import {AppNewGpuComponent} from '../app-new-gpu/app-new-gpu.component';
import {FormArray, FormBuilder, FormGroup, Validators} from '@angular/forms';
import { FormControlNames } from 'src/app/Constants';

@Component({
  selector: 'app-app-new-processor',
  templateUrl: './app-new-phone-cpu.component.html',
  styleUrls: ['./app-new-phone-cpu.component.css']
})
export class AppNewPhoneCpuComponent implements OnInit {

  static readonly DEFAULT_CORES_BLOCKS_AMOUNT = 1;

  public phoneCpuForm = this.fb.group({
    name: [null, [Validators.required, Validators.minLength(1)]],
    clockSpeedImMHz: [null, [Validators.required, Validators.min(1)]],
    integratedGpu: [null, [Validators.required]],
    coresBlocksAmount: [AppNewPhoneCpuComponent.DEFAULT_CORES_BLOCKS_AMOUNT, [Validators.required, Validators.min(1)]],
    digitalCapacityInBits: [null, [Validators.required, Validators.min(1)]],
    techprocessInNm: [null, [Validators.required, Validators.min(1)]]
  });
  coresBlocks: FormArray = null;
  integratedGpus: Array<MobileGpu> = [];
  FormControlNames = FormControlNames;

  constructor(@Inject(MAT_DIALOG_DATA) public data, public dialog: MatDialog,
              public gpuService: PhoneGpuService, public fb: FormBuilder) {
    this.updateCoresBlocks(AppNewPhoneCpuComponent.DEFAULT_CORES_BLOCKS_AMOUNT);
  }

  async ngOnInit(): Promise<void> {
    this.integratedGpus = await this.gpuService.getAllMobileGpus().toPromise();
    const coresBlocksAmount = this.phoneCpuForm.get('coresBlocksAmount');
    coresBlocksAmount.valueChanges.subscribe(v => {
      if (coresBlocksAmount.valid) {
        this.updateCoresBlocks(v);
      } else {
        this.coresBlocks = new FormArray([]);
        this.phoneCpuForm.setControl('coresBlocks', this.coresBlocks);
      }
    });
  }

  updateCoresBlocks(coresBlocksAmount: number): void {
    const controls: Array<FormGroup> = [];
    for (let i = 0; i < coresBlocksAmount; i++) {
      const group = this.fb.group({
        name: [null, [Validators.required, Validators.minLength(1)]],
        coresAmount: [null, [Validators.required, Validators.min(1)]],
        clockSpeedInMHz: [null, [Validators.required, Validators.min(1)]]
      });
      controls.push(group);
    }
    this.coresBlocks = new FormArray(controls);
    this.phoneCpuForm.setControl('coresBlocks', this.coresBlocks);
  }

  async createNewIntegratedGpu(): Promise<void> {
    const dialogRef = this.dialog.open(AppNewGpuComponent, {
      width: '600px',
    });
    const integratedGpu = await dialogRef.afterClosed().toPromise() as MobileGpu;
    if (integratedGpu) {
      this.integratedGpus.push(integratedGpu);
    }
  }
}
