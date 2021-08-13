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
import {BaseDataObjectWithName} from '../../model/base-data-object';
import {SimCardTypeService} from '../../services/sim-card-type.service';
import {DustAndMoistureProtectionService} from '../../services/dust-and-moisture-protection.service';
import {BaseDataObjectRestService} from '../../services/base-data-object-rest.service';
import {FingerprintScannerLocationService} from '../../services/fingerprint-scanner-location.service';
import {ScreenProtectionService} from '../../services/screen-protection.service';
import {MobileCpu} from '../../model/mobileCpu';
import {AppNewPhoneCpuComponent} from '../app-new-cpu/app-new-phone-cpu.component';
import {PhoneCpuService} from '../../services/phone-cpu.service';
import {FormBuilder, ValidationErrors, Validators} from '@angular/forms';
import {RamAndRomVariant} from '../../model/ram-and-rom-variant';
import {PhoneModel} from '../../model/phone-model';
import {PhoneModelService} from '../../services/phone-model.service';
import {ConnectionSocketService} from '../../services/connection-socket.service';
import {BodyColorService} from '../../services/body-color.service';
import {FormControlNames} from '../../Constants';

@Component({
  selector: 'app-new-phone-model',
  templateUrl: './app-new-phone-model.component.html',
  styleUrls: ['./app-new-phone-model.component.css']
})
export class AppNewPhoneModelComponent implements OnInit {
  constructor(public dialog: MatDialog, public manufacturerService: ManufacturerService,
              public screenTechnologyService: ScreenTechnologyService,
              public operationSystemWithVersionService: OperationSystemWithVersionService,
              public simCardTypeService: SimCardTypeService,
              public dustAndMoistureProtectionService: DustAndMoistureProtectionService,
              public fingerprintScannerLocationService: FingerprintScannerLocationService,
              public screenProtectionService: ScreenProtectionService,
              public mobileCpuService: PhoneCpuService, private fb: FormBuilder,
              private mobilePhoneModelService: PhoneModelService,
              public connectionSocketService: ConnectionSocketService,
              public bodyColorService: BodyColorService) {
    const mapper = () => this.fb.control([null]);
    const ramArray = this.fb.array(this.ramAndRomVariantsAmount.map(mapper));
    const romArray = this.fb.array(this.ramAndRomVariantsAmount.map(mapper));
    this.phoneModelForm.addControl('ramVariants', ramArray);
    this.phoneModelForm.addControl('romVariants', romArray);
  }

  phoneModelForm = this.fb.group({
    name: [null, [Validators.required]],
    manufacturer: [null, [Validators.required]],
    marketLaunchYear: [null, [Validators.required]],
    operationSystem: [null, [Validators.required]],
    screenDiagonalInInches: [null, [Validators.required]],
    horizontalScreenResolution: [null, [Validators.required]],
    verticalScreenResolution: [null, [Validators.required]],
    screenTechnology: [null, [Validators.required]],
    screenRefreshRate: [null, [Validators.required]],
    isMemoryCardSupported: [false],
    camerasAmount: [1, [Validators.min(1)]],
    cameraInMp: [null, [Validators.required]],
    simCardsAmount: [1, [Validators.required]],
    simCardType: [null, [Validators.required]],
    is5GSupported: [false],
    bodyColors: [null, [Validators.required]],
    dustAndMoistureProtection: [null, [Validators.required]],
    batteryCapacity: [null, [Validators.required]],
    fingerprintScannerLocation: [null, [Validators.required]],
    screenProtection: [null, [Validators.required]],
    cpu: [null, [Validators.required]],
    hasAudioProcessor: [false],
    frontCameraInMp: [null, [Validators.required]],
    hasAudioOutput: [false],
    connectionSocket: [null, [Validators.required]],
    length: [null, [Validators.required]],
    width: [null, [Validators.required]],
    thickness: [null, [Validators.required]],
    weight: [null, [Validators.required]]
  });
  ramAndRomVariantsAmount: Array<number> = [1];
  manufacturers: Array<Manufacturer> = [];
  operationSystemsWithVersions: Array<OperationSystemWithVersion> = [];
  screenTechnologies: Array<ScreenTechnology> = [];
  simCardTypes: Array<BaseDataObjectWithName> = [];
  dustAndMoistureProtections: Array<BaseDataObjectWithName> = [];
  fingerprintScannerLocations: Array<BaseDataObjectWithName> = [];
  screenProtections: Array<BaseDataObjectWithName> = [];
  cpus: Array<MobileCpu> = [];
  connectionSockets: Array<BaseDataObjectWithName> = [];
  bodyColors: Array<BaseDataObjectWithName> = [];
  FormControlNames = FormControlNames;

  async ngOnInit(): Promise<void> {
    this.loadAllToField(this.manufacturerService, 'manufacturers');
    this.loadAllToField(this.operationSystemWithVersionService, 'operationSystemsWithVersions');
    this.loadAllToField(this.screenTechnologyService, 'screenTechnologies');
    this.loadAllToField(this.mobileCpuService, 'cpus');
    this.loadAllToField(this.dustAndMoistureProtectionService, 'dustAndMoistureProtections');
    this.loadAllToField(this.fingerprintScannerLocationService, 'fingerprintScannerLocations');
    this.loadAllToField(this.screenProtectionService, 'screenProtections');
    this.loadAllToField(this.simCardTypeService, 'simCardTypes');
    this.loadAllToField(this.connectionSocketService, 'connectionSockets');
    this.loadAllToField(this.bodyColorService, 'bodyColors');
  }

  loadAllToField(service: BaseDataObjectRestService<any>, fieldName: string): void {
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

  async createNewBaseDataObjectAndReloadAll(dialogTitle: string, baseDataObjectService: BaseDataObjectRestService<BaseDataObjectWithName>)
    : Promise<Array<BaseDataObjectWithName>> {
    const dialogRef = this.dialog.open(AppDialogWithNameComponent, {
      width: '600px',
      data: {formTitle: dialogTitle}
    });
    const dialogData: BaseDataObjectWithName = await dialogRef.afterClosed().toPromise();
    // lock field and set loading
    await baseDataObjectService.save(dialogData).toPromise();
    const data = await baseDataObjectService.getAll().toPromise();
    // unlock field
    return data;
  }

  async createNewMobilePhoneCpu(): Promise<void> {
    const dialogRef = this.dialog.open(AppNewPhoneCpuComponent, {width: '600px'});
    const cpu = await dialogRef.afterClosed().toPromise() as MobileCpu;
    if (cpu) {
      console.log(cpu);
      await this.mobileCpuService.save(cpu).toPromise();
      this.cpus = await this.mobileCpuService.getAll().toPromise();
      console.log(this.cpus);
    }
  }

  async createNewPhoneModel(): Promise<void> {
    console.log('invalid ' + this.phoneModelForm.invalid);
    console.log('errors');
    this.getFormValidationErrors();
    console.log(this.phoneModelForm.errors);
    if (this.phoneModelForm.invalid) {
      this.phoneModelForm.markAllAsTouched();
      return;
    }
    console.log('create phone model');
    const rawValue = this.phoneModelForm.getRawValue();
    const ramAndRomVariants = this.ramAndRomVariantsAmount.map(
      (i) => new RamAndRomVariant(rawValue.ramVariants[i - 1], rawValue.romVariants[i - 1])
    );
    console.log('raw value sim card type');
    console.log(rawValue.simCardType);
    const mobilePhoneModel = new PhoneModel(rawValue.name, rawValue.manufacturer, rawValue.marketLaunchYear, rawValue.operationSystem,
      rawValue.screenDiagonalInInches, rawValue.horizontalScreenResolution, rawValue.verticalScreenResolution,
      rawValue.screenTechnology, rawValue.screenRefreshRate, ramAndRomVariants, rawValue.isMemoryCardSupported,
      rawValue.camerasAmount, rawValue.cameraInMp, rawValue.simCardsAmount, rawValue.simCardType, rawValue.is5GSupported,
      rawValue.dustAndMoistureProtection, rawValue.batteryCapacity, rawValue.fingerprintScannerLocation,
      rawValue.screenProtection, rawValue.cpu, rawValue.hasAudioProcessor, rawValue.frontCameraInMp, rawValue.hasAudioOutput,
      rawValue.connectionSocket, rawValue.length, rawValue.width, rawValue.thickness, rawValue.weight, rawValue.bodyColors);
    console.log('mobile phone model');
    console.log(mobilePhoneModel);
    console.log('mobile phone sim card type');
    console.log(mobilePhoneModel.simCardType);
    await this.mobilePhoneModelService.save(mobilePhoneModel).toPromise();
  }

  getFormValidationErrors(): void {
    Object.keys(this.phoneModelForm.controls).forEach(key => {
      const controlErrors: ValidationErrors = this.phoneModelForm.get(key).errors;
      if (controlErrors != null) {
        Object.keys(controlErrors).forEach(keyError => {
          console.log('Key control: ' + key + ', keyError: ' + keyError + ', err value: ', controlErrors[keyError]);
        });
      }
    });
  }

  nameDisplayFunction(object: BaseDataObjectWithName): string {
    let result = '';
    if (object && object.name) {
      result = object.name;
    }
    return result;
  }

}
