import {Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {ManufacturerService} from "../../services/manufacturer.service";
import {ScreenTechnologyService} from "../../services/screen-technology.service";
import {OperationSystemWithVersionService} from "../../services/operation-system-with-version.service";
import {SimCardTypeService} from "../../services/sim-card-type.service";
import {DustAndMoistureProtectionService} from "../../services/dust-and-moisture-protection.service";
import {FingerprintScannerLocationService} from "../../services/fingerprint-scanner-location.service";
import {ScreenProtectionService} from "../../services/screen-protection.service";
import {PhoneCpuService} from "../../services/phone-cpu.service";
import {FormArray, FormBuilder, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import {PhoneModelService} from "../../services/phone-model.service";
import {ConnectionSocketService} from "../../services/connection-socket.service";
import {ColorService} from "../../services/color.service";
import {Manufacturer} from "../../model/manufacturer";
import {OperationSystemWithVersion} from "../../model/operation-system-with-version";
import {ScreenTechnology} from "../../model/screen-technology";
import {BaseDataObjectWithName} from "../../model/base-data-object";
import {MobileCpu} from "../../model/mobileCpu";
import {BaseDataObjectRestService} from "../../services/base-data-object-rest.service";
import {AppDialogWithNameComponent} from "../app-dialog-with-name/app-dialog-with-name.component";
import {ManufacturerType} from "../../model/manufacturer-type";
import {AppNewOperationSystemWithVersionDialogComponent} from "../app-new-operation-system-with-version-dialog/app-new-operation-system-with-version-dialog.component";
import {OperationSystemType} from "../../model/operation-system-type";
import {AppNewPhoneCpuComponent} from "../app-new-cpu/app-new-phone-cpu.component";
import {ApiConstants, FormControlNames} from "../../Constants";
import {UtilService} from "../../services/util.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-edit-phone-model',
  templateUrl: './edit-phone-model.component.html',
  styleUrls: ['./edit-phone-model.component.css']
})
export class EditPhoneModelComponent implements OnInit {

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
    ramAndRomVariantsAmount: [null, [Validators.required, Validators.min(1)]],
    isMemoryCardSupported: [false],
    camerasAmount: [1, [Validators.min(1)]],
    cameraInMp: [null, [Validators.required]],
    simCardsAmount: [1, [Validators.required]],
    simCardType: [null, [Validators.required]],
    is5GSupported: [false],
    bodyColors: [null, [Validators.required]],
    dustAndMoistureProtection: [null],
    batteryCapacity: [null, [Validators.required]],
    fingerprintScannerLocation: [null, [Validators.required]],
    screenProtection: [null, [Validators.required]],
    cpu: [null, [Validators.required]],
    frontCameraInMp: [null, [Validators.required]],
    hasAudioOutput: [false],
    hasNfc: [false],
    connectionSocket: [null, [Validators.required]],
    length: [null, [Validators.required]],
    width: [null, [Validators.required]],
    thickness: [null, [Validators.required]],
    weight: [null, [Validators.required]]
  });
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
  images: Array<File>;
  ramAndRomVariants: FormArray = new FormArray([]);

  constructor(public dialog: MatDialog, public manufacturerService: ManufacturerService,
              public screenTechnologyService: ScreenTechnologyService,
              public operationSystemWithVersionService: OperationSystemWithVersionService,
              public simCardTypeService: SimCardTypeService,
              public dustAndMoistureProtectionService: DustAndMoistureProtectionService,
              public fingerprintScannerLocationService: FingerprintScannerLocationService,
              public screenProtectionService: ScreenProtectionService,
              public mobileCpuService: PhoneCpuService, private fb: FormBuilder,
              private phoneModelService: PhoneModelService,
              public connectionSocketService: ConnectionSocketService,
              public bodyColorService: ColorService, public util: UtilService, protected route: ActivatedRoute) {
  }

  async ngOnInit(): Promise<void> {
    const ramAndRomVariantsAmount = this.phoneModelForm.get('ramAndRomVariantsAmount');
    ramAndRomVariantsAmount.valueChanges.subscribe(v => {
      if (ramAndRomVariantsAmount.valid) {
        this.updateFormRamAndRomVariants(v);
      } else {
        this.ramAndRomVariants = new FormArray([]);
        this.phoneModelForm.setControl('ramAndRomVariants', this.ramAndRomVariants);
      }
    });
    await Promise.all([
      this.loadAllToField(this.manufacturerService, 'manufacturers'),
      this.loadAllToField(this.operationSystemWithVersionService, 'operationSystemsWithVersions'),
      this.loadAllToField(this.screenTechnologyService, 'screenTechnologies'),
      this.loadAllToField(this.mobileCpuService, 'cpus'),
      this.loadAllToField(this.dustAndMoistureProtectionService, 'dustAndMoistureProtections'),
      this.loadAllToField(this.fingerprintScannerLocationService, 'fingerprintScannerLocations'),
      this.loadAllToField(this.screenProtectionService, 'screenProtections'),
      this.loadAllToField(this.simCardTypeService, 'simCardTypes'),
      this.loadAllToField(this.connectionSocketService, 'connectionSockets'),
      this.loadAllToField(this.bodyColorService, 'bodyColors'),
    ]);
    this.loadPhoneModelToForm();
  }

  updateFormRamAndRomVariants(ramAndRomVariantsAmount: number): void {
    const controls: Array<FormGroup> = [];
    for (let i = 0; i < ramAndRomVariantsAmount; i++) {
      const group = this.fb.group({
        ram: [null, [Validators.required, Validators.min(1)]],
        rom: [null, [Validators.required, Validators.min(1)]]
      });
      controls.push(group);
    }
    this.ramAndRomVariants.controls.forEach((control, index) => {
      if (index < controls.length) {
        controls[index].patchValue({
          ram: control.get('ram').value,
          rom: control.get('rom').value
        });
      }
    });
    this.ramAndRomVariants = new FormArray(controls);
    this.phoneModelForm.setControl('ramAndRomVariants', this.ramAndRomVariants);
  }

  loadAllToField(service: BaseDataObjectRestService<any>, fieldName: string): Promise<Array<any> | void> {
    return service.getAll().toPromise().then(data => this[fieldName] = data);
  }

  async loadPhoneModelToForm(): Promise<void> {
    const id = this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM);
    const phoneModel = await this.phoneModelService.getById(id).toPromise();
    console.log('all screen technologies');
    console.log(this.screenTechnologies);
    console.log('phone model screen technology');
    console.log(phoneModel.screenTechnology);
    const map = new Map<string, any>([
      [FormControlNames.NAME, phoneModel.name],
      [FormControlNames.MANUFACTURER, phoneModel.manufacturer],
      [FormControlNames.MARKET_LAUNCH_YEAR, phoneModel.marketLaunchYear],
      [FormControlNames.OPERATION_SYSTEM, phoneModel.operationSystemWithVersion],
      [FormControlNames.SCREEN_DIAGONAL_IN_INCHES, phoneModel.screenDiagonalInInches],
      [FormControlNames.HORIZONTAL_SCREEN_RESOLUTION, phoneModel.horizontalScreenResolution],
      [FormControlNames.VERTICAL_SCREEN_RESOLUTION, phoneModel.verticalScreenResolution],
      [FormControlNames.SCREEN_REFRESH_RATE, phoneModel.screenRefreshRate],
      [FormControlNames.IS_MEMORY_CARD_SUPPORTED, phoneModel.isMemoryCardSupported],
      [FormControlNames.CAMERAS_AMOUNT, phoneModel.camerasAmount],
      [FormControlNames.CAMERA_IN_MP, phoneModel.cameraInMp],
      [FormControlNames.SIM_CARDS_AMOUNT, phoneModel.simCardsAmount],
      [FormControlNames.IS_5G_SUPPORTED, phoneModel.is5GSupported],
      [FormControlNames.BATTERY_CAPACITY, phoneModel.batteryCapacity],
      [FormControlNames.FRONT_CAMERA_IN_MP, phoneModel.frontCameraInMp],
      [FormControlNames.HAS_AUDIO_OUTPUT, phoneModel.hasAudioOutput],
      [FormControlNames.HAS_NFC, phoneModel.hasNfc],
      [FormControlNames.LENGTH, phoneModel.length],
      [FormControlNames.WIDTH, phoneModel.width],
      [FormControlNames.THICKNESS, phoneModel.thickness],
      [FormControlNames.WEIGHT, phoneModel.weight]
    ]);
    map.forEach((value, key) => {
      this.phoneModelForm.get(key).patchValue(value);
    });
    const operationSystemWithVersion = this.operationSystemsWithVersions.find(os => os.id === phoneModel.operationSystemWithVersion.id);
    this.phoneModelForm.get(FormControlNames.OPERATION_SYSTEM).patchValue(operationSystemWithVersion);
    const screenTechnology = this.screenTechnologies.find(v => v.id === phoneModel.screenTechnology.id);
    this.phoneModelForm.get(FormControlNames.SCREEN_TECHNOLOGY).patchValue(screenTechnology);
    const simCardType = this.simCardTypes.find(v => v.id === phoneModel.simCardType.id);
    this.phoneModelForm.get(FormControlNames.SIM_CARD_TYPE).patchValue(simCardType);
    const phoneModelBodyColors = this.bodyColors.filter(v => {
      const color = phoneModel.bodyColors.find(c => c.id === v.id);
      return color != null;
    });
    this.phoneModelForm.get(FormControlNames.BODY_COLORS).patchValue(phoneModelBodyColors);
    const screenProtection = this.screenProtections.find(v => phoneModel.screenProtection != null && phoneModel.screenProtection.id === v.id);
    this.phoneModelForm.get(FormControlNames.SCREEN_PROTECTION).patchValue(screenProtection);
    const dustAndMoistureProtection = this.dustAndMoistureProtections.find(v => phoneModel.dustAndMoistureProtection != null && phoneModel.dustAndMoistureProtection.id === v.id);
    this.phoneModelForm.get(FormControlNames.DUST_AND_MOISTURE_PROTECTION).patchValue(dustAndMoistureProtection);
    const scanner = this.fingerprintScannerLocations.find(v => phoneModel.fingerprintScannerLocation != null && phoneModel.fingerprintScannerLocation.id === v.id);
    this.phoneModelForm.get(FormControlNames.FINGERPRINT_SCANNER_LOCATION).patchValue(scanner);
    const mobileCpu = this.cpus.find(v => v.id === phoneModel.cpu.id);
    this.phoneModelForm.get(FormControlNames.CPU).patchValue(mobileCpu);
    // this.updateFormRamAndRomVariants(phoneModel)
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
    if (dialogData !== undefined) {
      await baseDataObjectService.save(dialogData).toPromise();
    }
    return await baseDataObjectService.getAll().toPromise();
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
    // console.log('invalid ' + this.phoneModelForm.invalid);
    // console.log('errors');
    // this.getFormValidationErrors();
    // console.log(this.phoneModelForm.errors);
    // if (this.phoneModelForm.invalid) {
    //   this.phoneModelForm.markAllAsTouched();
    //   return;
    // }
    // console.log('create phone model');
    // const rawValue = this.phoneModelForm.getRawValue();
    // const ramAndRomVariants = this.ramAndRomVariantsAmount.map(
    //   (i) => new RamAndRomVariant(rawValue.ramVariants[i - 1], rawValue.romVariants[i - 1])
    // );
    // console.log('raw value sim card type');
    // console.log(rawValue.simCardType);
    // const phoneModel = new PhoneModel(rawValue.name, rawValue.manufacturer, rawValue.marketLaunchYear, rawValue.operationSystem,
    //   rawValue.screenDiagonalInInches, rawValue.horizontalScreenResolution, rawValue.verticalScreenResolution,
    //   rawValue.screenTechnology, rawValue.screenRefreshRate, ramAndRomVariants, rawValue.isMemoryCardSupported,
    //   rawValue.camerasAmount, rawValue.cameraInMp, rawValue.simCardsAmount, rawValue.simCardType, rawValue.is5GSupported,
    //   rawValue.dustAndMoistureProtection, rawValue.batteryCapacity, rawValue.fingerprintScannerLocation,
    //   rawValue.screenProtection, rawValue.cpu, rawValue.frontCameraInMp, rawValue.hasAudioOutput,
    //   rawValue.connectionSocket, rawValue.length, rawValue.width, rawValue.thickness, rawValue.weight, rawValue.bodyColors, rawValue.hasNfc);
    // console.log('mobile phone model');
    // console.log(phoneModel);
    // const formData = new FormData();
    // console.log('this.images');
    // console.log(this.images);
    // this.images.forEach(image => formData.append('images', image));
    // formData.append('phoneModelJson', JSON.stringify(phoneModel));
    // await this.phoneModelService.send(formData).toPromise();
    // await this.phoneModelService.save(phoneModel).toPromise();
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

  onImagesChanged(event: Array<File>): void {
    this.images = event;
  }

}
