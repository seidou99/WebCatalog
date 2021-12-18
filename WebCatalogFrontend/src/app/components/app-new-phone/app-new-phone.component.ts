import {Component, OnInit, ViewChild} from '@angular/core';
import {FormControlNames} from '../../Constants';
import {BaseDataObjectWithName} from '../../model/base-data-object';
import {FormBuilder, Validators} from '@angular/forms';
import {PhoneService} from '../../services/phone.service';
import {Manufacturer} from '../../model/manufacturer';
import {ManufacturerService} from '../../services/manufacturer.service';
import {OperationSystemWithVersion} from '../../model/operation-system-with-version';
import {OperationSystemWithVersionService} from '../../services/operation-system-with-version.service';
import {ScreenTechnologyService} from '../../services/screen-technology.service';
import {ScreenTechnology} from '../../model/screen-technology';
import {SimCardTypeService} from '../../services/sim-card-type.service';
import {ColorService} from '../../services/color.service';
import {DustAndMoistureProtectionService} from '../../services/dust-and-moisture-protection.service';
import {DustAndMoistureProtection} from '../../model/dust-and-moisture-protection';
import {FingerprintScannerLocation} from '../../model/fingerprint-scanner-location';
import {FingerprintScannerLocationService} from '../../services/fingerprint-scanner-location.service';
import {ScreenProtectionService} from '../../services/screen-protection.service';
import {MobileCpu} from '../../model/mobileCpu';
import {PhoneCpuService} from '../../services/phone-cpu.service';
import {ConnectionSocketService} from '../../services/connection-socket.service';
import {SelectImagesComponent} from '../select-images/select-images.component';
import {AppDialogWithNameComponent} from '../app-dialog-with-name/app-dialog-with-name.component';
import {ManufacturerType} from '../../model/manufacturer-type';
import {MatDialog} from '@angular/material/dialog';
import {AppNewOperationSystemWithVersionDialogComponent} from '../app-new-operation-system-with-version-dialog/app-new-operation-system-with-version-dialog.component';
import {OperationSystemType} from '../../model/operation-system-type';
import {BaseDataObjectRestService} from '../../services/base-data-object-rest.service';
import {AppNewPhoneCpuComponent} from '../app-new-cpu/app-new-phone-cpu.component';

@Component({
  selector: 'app-app-new-phone',
  templateUrl: './app-new-phone.component.html',
  styleUrls: ['./app-new-phone.component.css']
})
export class AppNewPhoneComponent implements OnInit {
  @ViewChild('selectImagesComponent') selectImagesComponent: SelectImagesComponent;
  FormControlNames = FormControlNames;
  selectedFiles: Array<any>;
  phoneForm = this.fb.group({
    name: [null, [Validators.required]],
    manufacturer: [null, [Validators.required]],
    marketLaunchYear: [null, [Validators.required]],
    operationSystemWithVersion: [null, [Validators.required]],
    screenDiagonalInInches: [null, [Validators.required, Validators.min(0)]],
    horizontalScreenResolution: [null, [Validators.required, Validators.min(1)]],
    verticalScreenResolution: [null, [Validators.required, Validators.min(1)]],
    screenTechnology: [null, [Validators.required]],
    screenRefreshRate: [null, [Validators.required]],
    ramSizeInGB: [null, [Validators.required, Validators.min(0)]],
    romSizeInGB: [null, [Validators.required, Validators.min(0)]],
    isMemoryCardSupported: [false, [Validators.required]],
    camerasAmount: [null, [Validators.required, Validators.min(1)]],
    cameraInMp: [null, [Validators.required]],
    simCardsAmount: [null, [Validators.required, Validators.min(1)]],
    simCardType: [null, [Validators.required]],
    is5GSupported: [false, [Validators.required]],
    bodyColor: [null, [Validators.required]],
    dustAndMoistureProtection: [null],
    batteryCapacity: [null, [Validators.required, Validators.min(0)]],
    fingerprintScannerLocation: [null],
    screenProtection: [null, [Validators.required]],
    cpu: [null, [Validators.required]],
    frontCameraInMp: [null, [Validators.required, Validators.min(0)]],
    hasAudioOutput: [false, [Validators.required]],
    hasNfc: [false, [Validators.required]],
    connectionSocket: [null, [Validators.required]],
    length: [null, [Validators.required, Validators.min(0)]],
    width: [null, [Validators.required, Validators.min(0)]],
    thickness: [null, [Validators.required, Validators.min(0)]],
    weight: [null, [Validators.required, Validators.min(0)]],
  });
  manufacturers: Array<Manufacturer> = [];
  operationSystemsWithVersions: Array<OperationSystemWithVersion> = [];
  screenTechnologies: Array<ScreenTechnology> = [];
  simCardTypes: Array<BaseDataObjectWithName> = [];
  bodyColors: Array<BaseDataObjectWithName> = [];
  dustAndMoistureProtectionTypes: Array<DustAndMoistureProtection> = [];
  fingerprintScannerLocations: Array<FingerprintScannerLocation> = [];
  screenProtections: Array<BaseDataObjectWithName> = [];
  cpus: Array<MobileCpu> = [];
  connectionSockets: Array<BaseDataObjectWithName> = [];

  constructor(public fb: FormBuilder, public phoneService: PhoneService, protected manufacturerService: ManufacturerService, protected operationSystemWithVersionService: OperationSystemWithVersionService, protected screenTechnologyService: ScreenTechnologyService, protected simCardTypeService: SimCardTypeService, protected colorService: ColorService, protected dustAndMoistureProtectionService: DustAndMoistureProtectionService, protected fingerprintScannerLocationService: FingerprintScannerLocationService, protected screenProtectionService: ScreenProtectionService, protected cpuService: PhoneCpuService, protected connectionSocketService: ConnectionSocketService, protected dialog: MatDialog) {
  }

  async ngOnInit(): Promise<void> {
    this.manufacturerService.getAll().subscribe(data => this.manufacturers = data);
    this.operationSystemWithVersionService.getAll().subscribe(data => this.operationSystemsWithVersions = data);
    this.screenTechnologyService.getAll().subscribe(data => this.screenTechnologies = data);
    this.simCardTypeService.getAll().subscribe(data => this.simCardTypes = data);
    this.colorService.getAll().subscribe(data => this.bodyColors = data);
    this.dustAndMoistureProtectionService.getAll().subscribe(data => this.dustAndMoistureProtectionTypes = data);
    this.fingerprintScannerLocationService.getAll().subscribe(data => this.fingerprintScannerLocations = data);
    this.screenProtectionService.getAll().subscribe(data => this.screenProtections = data);
    this.cpuService.getAll().subscribe(data => this.cpus = data);
    this.connectionSocketService.getAll().subscribe(data => this.connectionSockets = data);
  }

  async createNewPhone(): Promise<void> {
    if (this.phoneForm.invalid) {
      this.phoneForm.markAllAsTouched();
      return;
    }
    if (!this.selectImagesComponent.mainImage) {
      window.alert('Необходимо главное изображение товара');
      return;
    }
    const rawValue = this.phoneForm.getRawValue();
    console.log(rawValue);
    console.log('main image');
    console.log(this.selectImagesComponent.mainImage);
    console.log('images');
    console.log(this.selectImagesComponent.selectedImages);
    const formData = new FormData();
    formData.append('mainImage', this.selectImagesComponent.mainImage.file);
    this.selectImagesComponent.selectedImages.map(v => v.file).forEach(image => formData.append('images', image));
    formData.append('jsonBody', JSON.stringify(rawValue));
    await this.phoneService.saveFormData(formData).toPromise();
    console.log('created');
  }

  async createNewManufacturer(): Promise<void> {
    const dialogRef = this.dialog.open(AppDialogWithNameComponent, {
      width: '600px',
      data: {formTitle: 'Создать нового производителя'}
    });
    const dialogData = await dialogRef.afterClosed().toPromise() as Manufacturer;
    if (dialogData === undefined) {
      return;
    }
    dialogData.manufacturerTypes = [ManufacturerType.MOBILE_PHONE];
    await this.manufacturerService.save(dialogData).toPromise();
    this.manufacturers = await this.manufacturerService.getAll().toPromise();
  }

  async createNewMobilePhoneOperationSystemWithVersion(): Promise<void> {
    const dialogRef = this.dialog.open(AppNewOperationSystemWithVersionDialogComponent, {
      width: '600px',
      data: {operationSystemType: OperationSystemType.MOBILE}
    });
    const dialogData: OperationSystemWithVersion = await dialogRef.afterClosed().toPromise();
    if (dialogData === undefined) {
      return;
    }
    await this.operationSystemWithVersionService.save(dialogData).toPromise();
    this.operationSystemsWithVersions = await this.operationSystemWithVersionService.getAll().toPromise();
    console.log(this.operationSystemsWithVersions);
  }

  async createNewBaseDataObjectAndReloadAll(dialogTitle: string, baseDataObjectService: BaseDataObjectRestService<BaseDataObjectWithName>)
    : Promise<Array<BaseDataObjectWithName>> {
    const dialogRef = this.dialog.open(AppDialogWithNameComponent, {
      width: '600px',
      data: {formTitle: dialogTitle}
    });
    const dialogData: BaseDataObjectWithName = await dialogRef.afterClosed().toPromise();
    if (dialogData !== undefined) {
      await baseDataObjectService.save(dialogData).toPromise();
    }
    return await baseDataObjectService.getAll().toPromise();
  }

  async createNewScreenTechnology(): Promise<void> {
    this.screenTechnologies = await this.createNewBaseDataObjectAndReloadAll('Создать новую технологию экрана',
      this.screenTechnologyService);
  }

  async createNewSimCardType(): Promise<void> {
    this.simCardTypes = await this.createNewBaseDataObjectAndReloadAll('Создать новый формат SIM-карты', this.simCardTypeService);
  }

  async createNewBodyColor(): Promise<void> {
    this.bodyColors = await this.createNewBaseDataObjectAndReloadAll(
      'Создать новый цвет корпуса', this.colorService
    );
  }

  async createNewDustMoistureProtection(): Promise<void> {
    this.dustAndMoistureProtectionTypes = await this.createNewBaseDataObjectAndReloadAll(
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
    const dialogRef = this.dialog.open(AppNewPhoneCpuComponent, {width: '600px'});
    const cpu = await dialogRef.afterClosed().toPromise() as MobileCpu;
    if (cpu) {
      console.log(cpu);
      await this.cpuService.save(cpu).toPromise();
      this.cpus = await this.cpuService.getAll().toPromise();
      console.log(this.cpus);
    }
  }

  async createNewConnectionSocket(): Promise<void> {
    this.connectionSockets = await this.createNewBaseDataObjectAndReloadAll(
      'Создать новый порт подключения', this.connectionSocketService
    );
  }

}
