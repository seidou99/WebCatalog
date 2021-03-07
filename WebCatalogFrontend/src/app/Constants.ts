export class Constants {
  static readonly SERVER_HOST = 'http://localhost';
  static readonly SERVER_PORT = '8080';
  static readonly SERVER_API_PATH = 'api';
  static readonly SERVER_API_URL = `${Constants.SERVER_HOST}:${Constants.SERVER_PORT}/${Constants.SERVER_API_PATH}`;
  static readonly MOBILE_PHONES_PATH = 'phones';
  static readonly MANUFACTURERS_PATH = 'manufacturers';
  static readonly SCREEN_TECHNOLOGIES = 'screen-technologies';
  static readonly OPERATION_SYSTEMS_PATH = 'operation-systems';
  static readonly OPERATION_SYSTEMS_WITH_VERSIONS_PATH = 'operation-systems-with-versions';
  static readonly SIM_CARD_TYPES_PATH = 'sim-card-types';
  static readonly DUST_AND_MOISTURE_PROTECTION_PATH = 'dust-and-moisture-protections';
  static readonly FINGERPRINT_SCANNER_LOCATIONS_PATH = 'fingerprint-scanner-locations';
  static readonly SCREEN_PROTECTIONS_PATH = 'screen-protections';
  static readonly MOBILE_PHONES_API_URL = `${Constants.SERVER_API_URL}/${Constants.MOBILE_PHONES_PATH}`;
  static readonly MANUFACTURERS_API_URL = `${Constants.SERVER_API_URL}/${Constants.MANUFACTURERS_PATH}`;
  static readonly OPERATION_SYSTEMS_API_URL = `${Constants.SERVER_API_URL}/${Constants.OPERATION_SYSTEMS_PATH}`;
  static readonly SCREEN_TECHNOLOGIES_API_URL = `${Constants.SERVER_API_URL}/${Constants.SCREEN_TECHNOLOGIES}`;
  static readonly OPERATION_SYSTEMS_WITH_VERSIONS_API_URL = `${Constants.SERVER_API_URL}/${Constants.OPERATION_SYSTEMS_WITH_VERSIONS_PATH}`;
  static readonly SIM_CARD_TYPES_API_URL = `${Constants.SERVER_API_URL}/${Constants.SIM_CARD_TYPES_PATH}`;
  static readonly DUST_AND_MOISTURE_PROTECTION_API_URL = `${Constants.SERVER_API_URL}/${Constants.DUST_AND_MOISTURE_PROTECTION_PATH}`;
  static readonly FINGERPRINT_SCANNER_LOCATIONS_API_URL = `${Constants.SERVER_API_URL}/${Constants.FINGERPRINT_SCANNER_LOCATIONS_PATH}`;
  static readonly SCREEN_PROTECTIONS_API_URL = `${Constants.SERVER_API_URL}/${Constants.SCREEN_PROTECTIONS_PATH}`;
}
