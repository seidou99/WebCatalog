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
import {FormBuilder} from '@angular/forms';
import {RamAndRomVariant} from '../../model/ram-and-rom-variant';
import {MobilePhoneModel} from '../../model/mobile-phone-model';
import {MobilePhoneModelService} from '../../services/mobile-phone-model.service';
import {ConnectionSocketService} from "../../services/connection-socket.service";
import {BodyColorService} from "../../services/body-color.service";

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
              public cpuService: CpuService, private fb: FormBuilder,
              private mobilePhoneModelService: MobilePhoneModelService,
              public connectionSocketService: ConnectionSocketService,
              public bodyColorService: BodyColorService) {
    const mapper = () => this.fb.control([null]);
    const ramArray = this.fb.array(this.ramAndRomVariantsAmount.map(mapper));
    const romArray = this.fb.array(this.ramAndRomVariantsAmount.map(mapper));
    this.phoneModelForm.addControl('ramVariants', ramArray);
    this.phoneModelForm.addControl('romVariants', romArray);
  }

  phoneModelForm = this.fb.group({
    name: [null],
    manufacturer: [null],
    marketLaunchYear: [null],
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
    hasAudioProcessor: [false],
    frontCameraInMp: [null],
    hasAudioOutput: [false],
    connectionSocket: [null],
    length: [null],
    width: [null],
    thickness: [null],
    weight: [null]
  });
  ramAndRomVariantsAmount: Array<number> = [1];
  manufacturers: Array<Manufacturer> = [];
  operationSystemsWithVersions: Array<OperationSystemWithVersion> = [];
  screenTechnologies: Array<ScreenTechnology> = [];
  simCardTypes: Array<BaseDataObject> = [];
  dustAndMoistureProtections: Array<BaseDataObject> = [];
  fingerprintScannerLocations: Array<BaseDataObject> = [];
  screenProtections: Array<BaseDataObject> = [];
  cpus: Array<Cpu> = [];
  connectionSockets: Array<BaseDataObject> = [];
  bodyColors: Array<BaseDataObject> = [];

  async ngOnInit(): Promise<void> {
    this.loadAllToField(this.manufacturerService, 'manufacturers');
    this.loadAllToField(this.operationSystemWithVersionService, 'operationSystemsWithVersions');
    this.loadAllToField(this.screenTechnologyService, 'screenTechnologies');
    this.loadAllToField(this.cpuService, 'cpus');
    this.loadAllToField(this.dustAndMoistureProtectionService, 'dustAndMoistureProtections');
    this.loadAllToField(this.fingerprintScannerLocationService, 'fingerprintScannerLocations');
    this.loadAllToField(this.screenProtectionService, 'screenProtections');
    this.loadAllToField(this.simCardTypeService, 'simCardTypes');
    this.loadAllToField(this.connectionSocketService, 'connectionSockets');
    this.loadAllToField(this.bodyColorService, 'bodyColors');
  }

  loadAllToField(service: BaseDataObjectService<any>, fieldName: string): void {
    service.getAll().subscribe(data => this[fieldName] = data);
  }

  changeRamAndRomVariantsAmount($event: any): void {
    this.ramAndRomVariantsAmount = [];
    for (let i = 0; i < $event.target.value; i++) {
      this.ramAndRomVariantsAmount.push(i + 1);
    }
    const mapper = () => this.fb.control([null]);
    const ramArray = this.fb.array(this.ramAndRomVariantsAmount.map(mapper));
    const romArray = this.fb.array(this.ramAndRomVariantsAmount.map(mapper));
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

  async createNewBodyColor(): Promise<void> {
    this.bodyColors = await this.createNewBaseDataObjectAndReloadAll(
      'Создать новый цвет корпуса', this.bodyColorService
    );
  }

  async createNewConnectionSocket(): Promise<void> {
    this.connectionSockets = await this.createNewBaseDataObjectAndReloadAll(
      'Создать новый порт подключения', this.connectionSocketService
    );
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

  async createNewPhoneModel(): Promise<void> {
    const rawValue = this.phoneModelForm.getRawValue();
    const ramAndRomVariants = this.ramAndRomVariantsAmount.map(
      (i) => new RamAndRomVariant(rawValue.ramVariants[i - 1], rawValue.romVariants[i - 1])
    );
    const mobilePhoneModel = new MobilePhoneModel(rawValue.name, rawValue.manufacturer, rawValue.marketLaunchYear, rawValue.operationSystem,
      rawValue.screenDiagonalInInches, rawValue.horizontalScreenResolution, rawValue.verticalScreenResolution,
      rawValue.screenTechnology, rawValue.screenRefreshRate, ramAndRomVariants, rawValue.isMemoryCardSupported,
      rawValue.camerasAmount, rawValue.cameraInMp, rawValue.simCardsAmount, rawValue.simCardTypes, rawValue.is5GSupported,
      rawValue.bodyColor, rawValue.dustAndMoistureProtection, rawValue.batteryCapacity, rawValue.fingerprintScannerLocation,
      rawValue.screenProtection, rawValue.cpu, rawValue.hasAudioProcessor, rawValue.frontCameraInMp, rawValue.hasAudioOutput,
      rawValue.connectionSocket, rawValue.length, rawValue.width, rawValue.thickness, rawValue.weight);
    console.log('mobile phone model');
    console.log(mobilePhoneModel);
    await this.mobilePhoneModelService.save(mobilePhoneModel).toPromise();
  }

  nameDisplayFunction(object: BaseDataObject): string {
    let result = '';
    if (object && object.name) {
      result = object.name;
    }
    return result;
  }

}
