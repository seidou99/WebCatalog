import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog} from '@angular/material/dialog';
import {Cpu, CpuCoresBlock} from '../../model/cpu';
import {Gpu} from '../../model/gpu';
import {GpuService} from '../../services/gpu.service';
import {AppNewGpuComponent} from '../app-new-gpu/app-new-gpu.component';

@Component({
  selector: 'app-app-new-processor',
  templateUrl: './app-new-cpu.component.html',
  styleUrls: ['./app-new-cpu.component.css']
})
export class AppNewCpuComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data, public dialog: MatDialog,
              public gpuService: GpuService) {
  }

  public result = new Cpu();
  hasIntegratedGpu = true;
  coresBlocks: Array<number> = [];
  integratedGpus: Array<Gpu> = [];

  async ngOnInit(): Promise<void> {
    this.integratedGpus = await this.gpuService.getAllMobileGpus().toPromise();
  }

  changeCoresBlocksAmount($event): void {
    this.coresBlocks = [];
    for (let i = 0; i < $event.target.value; i++) {
      this.coresBlocks.push(i);
      this.result.coresBlocks.push(new CpuCoresBlock());
    }
  }

  async createNewIntegratedGpu(): Promise<void> {
    const dialogRef = this.dialog.open(AppNewGpuComponent, {
      width: '600px',
    });
    const integratedGpu = await dialogRef.afterClosed().toPromise() as Gpu;
    if (integratedGpu) {
      this.integratedGpus.push(integratedGpu);
    }
  }
}
