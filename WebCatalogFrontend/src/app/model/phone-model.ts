import {BaseDataObject} from "./base-data-object";
import {Manufacturer} from "./manufacturer";
import {OperationSystemWithVersion} from "./operation-system-with-version";
import {ScreenTechnology} from "./screen-technology";
import {RamAndRomVariant} from "./ram-and-rom-variant";
import {DustAndMoistureProtection} from "./dust-and-moisture-protection";
import {FingerprintScannerLocation} from "./fingerprint-scanner-location";
import {Cpu} from "./cpu";

export class PhoneModel extends BaseDataObject {

  manufacturer: Manufacturer;
  marketLaunchYear: number;
  operationSystemWithVersion: OperationSystemWithVersion;
  screenDiagonalInInches: number;
  horizontalScreenResolution: number;
  verticalScreenResolution: number;
  screenTechnology: ScreenTechnology;
  screenRefreshRate: number;
  ramAndRomVariants: Array<RamAndRomVariant>;
  isMemoryCardSupported: boolean;
  camerasAmount: number;
  cameraInMp: number;
  simCardsAmount: number;
  simCardType: BaseDataObject;
  is5GSupported: boolean;
  dustAndMoistureProtection: DustAndMoistureProtection;
  batteryCapacity: number;
  fingerprintScannerLocation: FingerprintScannerLocation;
  screenPpi: number;
  screenProtection: BaseDataObject;
  cpu: Cpu;
  hasAudioProcessor: boolean;
  frontCameraInMp: number;
  hasAudioOutput: boolean;
  connectionSocket: BaseDataObject;
  length: number;
  width: number;
  thickness: number;
  weight: number;
  bodyColors: Array<BaseDataObject>;

  constructor(name: string, manufacturer: Manufacturer, marketLaunchYear: number, operationSystem: OperationSystemWithVersion, screenDiagonalInInches: number, horizontalScreenResolution: number, verticalScreenResolution: number, screenTechnology: ScreenTechnology, screenRefreshRate: number, ramAndRomVariants: Array<RamAndRomVariant>, isMemoryCardSupported: boolean, camerasAmount: number, cameraInMp: number, simCardsAmount: number, simCardType: BaseDataObject, is5GSupported: boolean, dustAndMoistureProtection: DustAndMoistureProtection, batteryCapacity: number, fingerprintScannerLocation: FingerprintScannerLocation, screenProtection: BaseDataObject, cpu: Cpu, hasAudioProcessor: boolean, frontCameraInMp: number, hasAudioOutput: boolean, connectionSocket: BaseDataObject, length: number, width: number, thickness: number, weight: number, bodyColors: Array<BaseDataObject>) {
    super();
    this.name = name;
    this.manufacturer = manufacturer;
    this.marketLaunchYear = marketLaunchYear;
    this.operationSystemWithVersion = operationSystem;
    this.screenDiagonalInInches = screenDiagonalInInches;
    this.horizontalScreenResolution = horizontalScreenResolution;
    this.verticalScreenResolution = verticalScreenResolution;
    this.screenTechnology = screenTechnology;
    this.screenRefreshRate = screenRefreshRate;
    this.ramAndRomVariants = ramAndRomVariants;
    this.isMemoryCardSupported = isMemoryCardSupported;
    this.camerasAmount = camerasAmount;
    this.cameraInMp = cameraInMp;
    this.simCardsAmount = simCardsAmount;
    this.simCardType = simCardType;
    this.is5GSupported = is5GSupported;
    this.dustAndMoistureProtection = dustAndMoistureProtection;
    this.batteryCapacity = batteryCapacity;
    this.fingerprintScannerLocation = fingerprintScannerLocation;
    this.screenProtection = screenProtection;
    this.cpu = cpu;
    this.hasAudioProcessor = hasAudioProcessor;
    this.frontCameraInMp = frontCameraInMp;
    this.hasAudioOutput = hasAudioOutput;
    this.connectionSocket = connectionSocket;
    this.length = length;
    this.width = width;
    this.thickness = thickness;
    this.weight = weight;
    this.bodyColors = bodyColors;

  }
}

export enum MobilePhoneType {

  SMARTPHONE = 'SMARTPHONE', SIMPLE_MOBILE_PHONE = 'SIMPLE_MOBILE_PHONE'
}
