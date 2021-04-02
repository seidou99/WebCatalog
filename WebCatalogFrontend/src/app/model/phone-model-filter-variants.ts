import {Manufacturer} from "./manufacturer";
import {OperationSystemWithVersion} from "./operation-system-with-version";
import {ScreenResolution} from "./screen-resolution";
import {ScreenTechnology} from "./screen-technology";
import {BaseDataObject} from "./base-data-object";
import {DustAndMoistureProtection} from "./dust-and-moisture-protection";
import {FingerprintScannerLocation} from "./fingerprint-scanner-location";
import {Cpu} from "./cpu";
import {Gpu} from "./gpu";

export class PhoneModelFilterVariants {
  manufacturers: Array<Manufacturer> = [];
  marketLaunchYears: Array<number> = [];
  operationSystemsWithVersion: Array<OperationSystemWithVersion> = [];
  screenDiagonalInInches: Array<number> = [];
  screenResolutions: Array<ScreenResolution> = [];
  screenTechnologies: Array<ScreenTechnology> = [];
  screenRefreshRates: Array<number> = [];
  rams: Array<number> = [];
  roms: Array<number> = [];
  camerasAmounts: Array<number> = [];
  cameras: Array<number>;
  simCardAmounts: Array<number>;
  simCardTypes: Array<BaseDataObject> = [];
  bodyColors: Array<BaseDataObject> = [];
  dustAndMoistureProtections: Array<DustAndMoistureProtection> = [];
  batteryCapacities: Array<number> = [];
  fingerprintScannerLocations: Array<FingerprintScannerLocation> = [];
  screenProtections: Array<BaseDataObject> = [];
  cpus: Array<Cpu> = [];
  coreAmounts: Array<number> = [];
  cpuClockSpeeds: Array<number> = [];
  cpuTechprocesses: Array<number> = [];
  gpus: Array<Gpu> = [];
  frontCameras: Array<number> = [];
  connectionSockets: Array<BaseDataObject> = [];
  lengthVariants: Array<number> = [];
  widthVariants: Array<number> = [];
  thicknessVariants: Array<number> = [];
  weightVariants: Array<number> = [];
}