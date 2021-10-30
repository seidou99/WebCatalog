import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {Manufacturer} from "../../model/manufacturer";
import {OperationSystemWithVersion} from "../../model/operation-system-with-version";
import {ScreenTechnology} from "../../model/screen-technology";
import {BaseDataObjectWithName} from "../../model/base-data-object";
import {DustAndMoistureProtection} from "../../model/dust-and-moisture-protection";
import {FingerprintScannerLocation} from "../../model/fingerprint-scanner-location";
import {MobileCpu} from "../../model/mobileCpu";
import {PhoneService} from "../../services/phone.service";
import {ManufacturerService} from "../../services/manufacturer.service";
import {OperationSystemWithVersionService} from "../../services/operation-system-with-version.service";
import {ScreenTechnologyService} from "../../services/screen-technology.service";
import {SimCardTypeService} from "../../services/sim-card-type.service";
import {ColorService} from "../../services/color.service";
import {DustAndMoistureProtectionService} from "../../services/dust-and-moisture-protection.service";
import {FingerprintScannerLocationService} from "../../services/fingerprint-scanner-location.service";
import {ScreenProtectionService} from "../../services/screen-protection.service";
import {PhoneCpuService} from "../../services/phone-cpu.service";
import {ConnectionSocketService} from "../../services/connection-socket.service";
import {ApiConstants, FormControlNames} from 'src/app/Constants';
import {ActivatedRoute} from "@angular/router";
import {Phone} from "../../model/phone";
import {EditProductImagesComponent} from "../edit-product-images/edit-product-images.component";
import {UtilService} from "../../services/util.service";

@Component({
  selector: 'app-edit-phone',
  templateUrl: './edit-phone.component.html',
  styleUrls: ['./edit-phone.component.css']
})
export class EditPhoneComponent implements OnInit {

  @ViewChild('editProductImagesComponent') editProductImagesComponent: EditProductImagesComponent;
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
  phone: Phone;

  constructor(public fb: FormBuilder, public phoneService: PhoneService, protected manufacturerService: ManufacturerService, protected operationSystemWithVersionService: OperationSystemWithVersionService, protected screenTechnologyService: ScreenTechnologyService, protected simCardTypeService: SimCardTypeService, protected colorService: ColorService, protected dustAndMoistureProtectionService: DustAndMoistureProtectionService, protected fingerprintScannerLocationService: FingerprintScannerLocationService, protected screenProtectionService: ScreenProtectionService, protected cpuService: PhoneCpuService, protected connectionSocketService: ConnectionSocketService, protected route: ActivatedRoute, protected util: UtilService) {
  }

  async ngOnInit(): Promise<void> {
    const phoneId = this.route.snapshot.paramMap.get(ApiConstants.ID_ROUTE_PARAM);
    await Promise.all<any>([
      this.manufacturerService.getAll().toPromise().then(data => this.manufacturers = data),
      this.operationSystemWithVersionService.getAll().toPromise().then(data => this.operationSystemsWithVersions = data),
      this.screenTechnologyService.getAll().toPromise().then(data => this.screenTechnologies = data),
      this.simCardTypeService.getAll().toPromise().then(data => this.simCardTypes = data),
      this.colorService.getAll().toPromise().then(data => this.bodyColors = data),
      this.dustAndMoistureProtectionService.getAll().toPromise().then(data => this.dustAndMoistureProtectionTypes = data),
      this.fingerprintScannerLocationService.getAll().toPromise().then(data => this.fingerprintScannerLocations = data),
      this.screenProtectionService.getAll().toPromise().then(data => this.screenProtections = data),
      this.cpuService.getAll().toPromise().then(data => this.cpus = data),
      this.connectionSocketService.getAll().toPromise().then(data => this.connectionSockets = data),
      this.phoneService.getById(phoneId).toPromise().then(data => this.phone = data)
    ]);
    console.log('phone', this.phone);

    this.updateForm(this.phone);
  }

  protected updateForm(phone: Phone): void {
    const comparator = (id: number) => {
      return (v: any): boolean => {
        return v.id === id;
      };
    };
    const findById = (values: Array<any>, valueToFind: any): any => {
      if (valueToFind !== null && valueToFind !== undefined) {
        return values.find(comparator(valueToFind.id));
      }
      return null;
    };
    this.phoneForm.patchValue({
      name: phone.name,
      manufacturer: findById(this.manufacturers, phone.manufacturer),
      marketLaunchYear: phone.marketLaunchYear,
      operationSystemWithVersion: findById(this.operationSystemsWithVersions, phone.operationSystemWithVersion),
      screenDiagonalInInches: phone.screenDiagonalInInches,
      horizontalScreenResolution: phone.horizontalScreenResolution,
      verticalScreenResolution: phone.verticalScreenResolution,
      screenTechnology: findById(this.screenTechnologies, phone.screenTechnology),
      screenRefreshRate: phone.screenRefreshRate,
      ramSizeInGB: phone.ramSizeInGB,
      romSizeInGB: phone.romSizeInGB,
      isMemoryCardSupported: phone.isMemoryCardSupported,
      camerasAmount: phone.camerasAmount,
      cameraInMp: phone.cameraInMp,
      simCardsAmount: phone.simCardsAmount,
      simCardType: findById(this.simCardTypes, phone.simCardType),
      is5GSupported: phone.is5GSupported,
      bodyColor: findById(this.bodyColors, phone.bodyColor),
      dustAndMoistureProtection: findById(this.dustAndMoistureProtectionTypes, phone.dustAndMoistureProtection),
      batteryCapacity: phone.batteryCapacity,
      fingerprintScannerLocation: findById(this.fingerprintScannerLocations, phone.fingerprintScannerLocation),
      screenProtection: findById(this.screenProtections, phone.screenProtection),
      cpu: findById(this.cpus, phone.cpu),
      hasAudioOutput: phone.hasAudioOutput,
      frontCameraInMp: phone.frontCameraInMp,
      hasNfc: phone.hasNfc,
      connectionSocket: findById(this.connectionSockets, phone.connectionSocket),
      length: phone.length,
      width: phone.width,
      thickness: phone.thickness,
      weight: phone.weight
    });
  }

  async createNewPhone(): Promise<void> {
    // console.log('is form invalid ', this.phoneForm.invalid);
    // this.util.logFormValidationErrors(this.phoneForm);
    if (this.phoneForm.invalid) {
      this.phoneForm.markAllAsTouched();
      window.alert('Поля ввода заполнены неправильно');
      return;
    }
    if (!this.validateImages()) {
      window.alert(this.getImagesValidationReason());
      return;
    }
    const rawValue = this.phoneForm.getRawValue();
    console.log('raw value', rawValue);
    const formData = new FormData();
    console.log(this.editProductImagesComponent.selectedImages);
    if (this.editProductImagesComponent.selectedImages.length !== 0) {
      this.editProductImagesComponent.selectedImages.map(v => v.file).forEach(image => formData.append('newImages', image));
    }
    if (this.editProductImagesComponent.mainImage != null) {
      formData.append('newMainImage', this.editProductImagesComponent.mainImage.file);
    }
    console.log('old images', this.editProductImagesComponent.oldImages);
    console.log('old main image', this.editProductImagesComponent.oldMainImage);
    rawValue.mainImage = this.editProductImagesComponent.oldMainImage;
    rawValue.images = this.editProductImagesComponent.oldImages;
    rawValue.id = this.phone.id;
    formData.append('jsonBody', JSON.stringify(rawValue));
    await this.phoneService.updatePhone(formData).toPromise();
    console.log('created');
  }

  validateImages(): boolean {
    const hasOldMainImage = this.editProductImagesComponent.oldMainImage != null;
    const hasNewMainImage = this.editProductImagesComponent.mainImage != null;
    return (hasOldMainImage && !hasNewMainImage) || (!hasOldMainImage && hasNewMainImage);
  }

  getImagesValidationReason(): string {
    let result = '';
    const hasOldMainImage = this.editProductImagesComponent.oldMainImage != null;
    const hasNewMainImage = this.editProductImagesComponent.mainImage != null;
    if (hasOldMainImage && hasNewMainImage) {
      result = 'Должно быть только одно главное изображение товара';
    } else if (!hasOldMainImage && !hasNewMainImage) {
      result = 'Должно быть главное изображние товара';
    }
    return result;
  }

}
