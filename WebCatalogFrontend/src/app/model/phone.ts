import {BaseDataObjectWithName, Image} from './base-data-object';
import {Manufacturer} from "./manufacturer";
import {OperationSystemWithVersion} from "./operation-system-with-version";
import {ScreenTechnology} from "./screen-technology";
import {DustAndMoistureProtection} from "./dust-and-moisture-protection";
import {FingerprintScannerLocation} from "./fingerprint-scanner-location";
import {MobileCpu} from "./mobileCpu";

export class Phone extends BaseDataObjectWithName {

  manufacturer: Manufacturer;
  marketLaunchYear: number;
  operationSystemWithVersion: OperationSystemWithVersion;
  screenDiagonalInInches: number;
  horizontalScreenResolution: number;
  verticalScreenResolution: number;
  screenTechnology: ScreenTechnology;
  screenRefreshRate: number;
  ramSizeInGB: number;
  romSizeInGB: number;
  isMemoryCardSupported: boolean;
  camerasAmount: number;
  cameraInMp: number;
  simCardsAmount: number;
  simCardType: BaseDataObjectWithName;
  is5GSupported: boolean;
  dustAndMoistureProtection: DustAndMoistureProtection;
  batteryCapacity: number;
  fingerprintScannerLocation: FingerprintScannerLocation;
  screenPpi: number;
  screenProtection: BaseDataObjectWithName;
  cpu: MobileCpu;
  frontCameraInMp: number;
  hasAudioOutput: boolean;
  connectionSocket: BaseDataObjectWithName;
  length: number;
  width: number;
  thickness: number;
  weight: number;
  bodyColor: BaseDataObjectWithName;
  hasNfc: boolean;
  images: Array<Image>;
  mainImage: Image;

}
