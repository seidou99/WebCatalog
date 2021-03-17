import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {ManufacturerService} from '../../services/manufacturer.service';
import {Manufacturer} from '../../model/manufacturer';
import {AppDialogWithNameComponent} from '../app-dialog-with-name/app-dialog-with-name.component';
import {ScreenTechnology} from '../../model/screen-technology';
import {ScreenTechnologyService} from '../../services/screen-technology.service';
import {AppNewOperationSystemWithVersionDialogComponent} from '../app-new-operation-system-with-version-dialog/app-new-operation-system-with-version-dialog.component';
import {OperationSystemType} from '../../model/operation-system-type';
import {OperationSystemWithVersion} from '../../model/operation-system-with-version';
import {OperationSystemWithVersionService} from '../../services/operation-system-with-version.service';
import {ManufacturerType} from '../../model/manufacturer-type';
import {BaseDataObject} from '../../model/base-data-object';
import {SimCardTypeService} from '../../services/sim-card-type.service';
import {DustAndMoistureProtectionService} from '../../services/dust-and-moisture-protection.service';
import {BaseDataObjectService} from '../../services/base-data-object-service';
import {FingerprintScannerLocationService} from '../../services/fingerprint-scanner-location.service';
import {ScreenProtectionService} from '../../services/screen-protection.service';
import {Cpu} from '../../model/cpu';
import {AppNewCpuComponent} from '../app-new-cpu/app-new-cpu.component';
import {CpuService} from '../../services/cpu.service';
import {GpuType} from '../../model/gpu';
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-new-phone-model',
  templateUrl: './new-phone-model.component.html',
  styleUrls: ['./new-phone-model.component.css']
})
export class NewPhoneModelComponent implements OnInit {
  constructor(public dialog: MatDialog, public manufacturerService: ManufacturerService,
              public screenTechnologyService: ScreenTechnologyService,
              public operationSystemWithVersionService: OperationSystemWithVersionService,
              public simCardTypeService: SimCardTypeService,
              public dustAndMoistureProtectionService: DustAndMoistureProtectionService,
              public fingerprintScannerLocationService: FingerprintScannerLocationService,
              public screenProtectionService: ScreenProtectionService,
              public cpuService: CpuService,
              private fb: FormBuilder) {
    const mapper = () => this.fb.control([null]);
    const ramArray = this.fb.array(this.ramAndRomVariants.map(mapper));
    const romArray = this.fb.array(this.ramAndRomVariants.map(mapper));
    this.phoneModelForm.addControl('ramVariants', ramArray);
    this.phoneModelForm.addControl('romVariants', romArray);
  }

  phoneModelForm = this.fb.group({
    manufacturer: [null],
    releaseYear: [null],
    operationSystem: [null],
    screenDiagonalInInches: [null],
    horizontalScreenResolution: [null],
    verticalScreenResolution: [null],
    screenTechnology: [null],
    screenRefreshRate: [null],
    isMemoryCardSupported: [false],
    camerasAmount: [1],
    cameraInMp: [null],
    simCardsAmount: [1],
    simCardType: [null],
    is5GSupported: [false],
    bodyColor: [null],
    dustAndMoistureProtection: [null],
    batteryCapacity: [null],
    fingerprintScannerLocation: [null],
    screenResolutionPpi: [null],
    screenProtection: [null],
    cpu: [null],
    audioProcessor: [false],
    frontCamera: [null],
    audioOutput: [false],
    connectionSocket: [null],
    length: [null],
    width: [null],
    thickness: [null],
    weight: [null]
  });
  ramAndRomVariants: Array<number> = [1];
  manufacturers: Array<Manufacturer> = [];
  operationSystemsWithVersions: Array<OperationSystemWithVersion> = [];
  screenTechnologies: Array<ScreenTechnology> = [];
  simCardTypes: Array<BaseDataObject> = [];
  dustAndMoistureProtections: Array<BaseDataObject> = [];
  fingerprintScannerLocations: Array<BaseDataObject> = [];
  screenProtections: Array<BaseDataObject> = [];
  cpus: Array<Cpu> = [];

  async ngOnInit(): Promise<void> {
    this.manufacturers = await this.manufacturerService.getAll().toPromise();
    this.operationSystemsWithVersions = await this.operationSystemWithVersionService.getAll().toPromise();
    this.screenTechnologies = await this.screenTechnologyService.getAll().toPromise();
    console.log(this.manufacturers);
  }

  changeRamAndRomVariants($event: any): void {
    this.ramAndRomVariants = [];
    for (let i = 0; i < $event.target.value; i++) {
      this.ramAndRomVariants.push(i + 1);
    }
    const mapper = () => this.fb.control([null]);
    const ramArray = this.fb.array(this.ramAndRomVariants.map(mapper));
    const romArray = this.fb.array(this.ramAndRomVariants.map(mapper));
    this.phoneModelForm.setControl('ramVariants', ramArray);
    this.phoneModelForm.setControl('romVariants', romArray);
  }

  async createNewManufacturer(): Promise<void> {
    const dialogRef = this.dialog.open(AppDialogWithNameComponent, {
      width: '600px',
      data: {formTitle: 'Создать нового производителя'}
    });
    const dialogData = await dialogRef.afterClosed().toPromise() as Manufacturer;
    dialogData.manufacturerType = ManufacturerType.MOBILE_PHONE;
    await this.manufacturerService.save(dialogData).toPromise();
    this.manufacturers = await this.manufacturerService.getAll().toPromise();
  }

  async createNewMobilePhoneOperationSystemWithVersion(): Promise<void> {
    const dialogRef = this.dialog.open(AppNewOperationSystemWithVersionDialogComponent, {
      width: '600px',
      data: {operationSystemType: OperationSystemType.MOBILE}
    });
    const dialogData: OperationSystemWithVersion = await dialogRef.afterClosed().toPromise();
    console.log(dialogData);
    await this.operationSystemWithVersionService.save(dialogData).toPromise();
    this.operationSystemsWithVersions = await this.operationSystemWithVersionService.getAll().toPromise();
    console.log(this.operationSystemsWithVersions);
  }

  async createNewScreenTechnology(): Promise<void> {
    this.screenTechnologies = await this.createNewBaseDataObjectAndReloadAll('Создать новую технологию экрана',
      this.screenTechnologyService);
  }

  async createNewSimCardType(): Promise<void> {
    this.simCardTypes = await this.createNewBaseDataObjectAndReloadAll('Создать новый формат SIM-карты', this.simCardTypeService);
  }

  async createNewDustMoistureProtection(): Promise<void> {
    this.dustAndMoistureProtections = await this.createNewBaseDataObjectAndReloadAll(
      'Создать новый тип пыле- и влагозащиты', this.dustAndMoistureProtectionService);
  }

  async createNewFingerprintScannerLocation(): Promise<void> {
    this.fingerprintScannerLocations = await this.createNewBaseDataObjectAndReloadAll(
      'Создать новое расположение сканера отпечатков пальцев', this.fingerprintScannerLocationService);
  }

  async createNewScreenProtection(): Promise<void> {
    this.screenProtections = await this.createNewBaseDataObjectAndReloadAll(
      'Создать новый тип защитного стекла', this.screenProtectionService
    );
  }

  async createNewMobilePhoneCpu(): Promise<void> {
    const dialogRef = this.dialog.open(AppNewCpuComponent, {width: '600px'});
    const cpu = await dialogRef.afterClosed().toPromise() as Cpu;
    if (cpu) {
      if (cpu.integratedGpu) {
        cpu.integratedGpu.gpuType = GpuType.MOBILE;
        cpu.integratedGpu.isIntegrated = true;
      }
      console.log(cpu);
      await this.cpuService.save(cpu).toPromise();
      this.cpus = await this.cpuService.getAll().toPromise();
      console.log(this.cpus);
    }

  }

  async createNewBaseDataObjectAndReloadAll(dialogTitle: string, baseDataObjectService: BaseDataObjectService<BaseDataObject>)
    : Promise<Array<BaseDataObject>> {
    const dialogRef = this.dialog.open(AppDialogWithNameComponent, {
      width: '600px',
      data: {formTitle: dialogTitle}
    });
    const dialogData: BaseDataObject = await dialogRef.afterClosed().toPromise();
    // lock field and set loading
    await baseDataObjectService.save(dialogData).toPromise();
    const data = await baseDataObjectService.getAll().toPromise();
    // unlock field
    return data;
  }

  async createNewPhoneModel(): Promise<void> {
    const rawValue = this.phoneModelForm.getRawValue();
    console.log('poshel nahui');
    console.log(rawValue);
  }

  nameDisplayFunction(object: BaseDataObject): string {
    let result = '';
    if (object && object.name) {
      result = object.name;
    }
    return result;
  }

}
