export class ApiConstants {
  static readonly SERVER_HOST = 'http://localhost';
  static readonly SERVER_PORT = '8080';
  static readonly ID_ROUTE_PARAM = 'id';
  static readonly SERVER_API_PATH = 'api';
  static readonly SERVER_API_URL = `${ApiConstants.SERVER_HOST}:${ApiConstants.SERVER_PORT}/${ApiConstants.SERVER_API_PATH}`;
  static readonly MOBILE_PHONES_PATH = 'phones';
  static readonly MANUFACTURERS_PATH = 'manufacturers';
  static readonly SCREEN_TECHNOLOGIES = 'screen-technologies';
  static readonly OPERATION_SYSTEMS_PATH = 'operation-systems';
  static readonly OPERATION_SYSTEMS_WITH_VERSIONS_PATH = 'operation-systems-with-versions';
  static readonly SIM_CARD_TYPES_PATH = 'sim-card-types';
  static readonly DUST_AND_MOISTURE_PROTECTION_PATH = 'dust-and-moisture-protections';
  static readonly FINGERPRINT_SCANNER_LOCATIONS_PATH = 'fingerprint-scanner-locations';
  static readonly SCREEN_PROTECTIONS_PATH = 'screen-protections';
  static readonly PHONE_MODELS_PATH = 'models';
  static readonly GPUS_PATH = 'gpus';
  static readonly CPUS_PATH = 'cpus';
  static readonly CONNECTION_SOCKETS_PATH = 'connection-sockets';
  static readonly COLORS_PATH = 'colors';
  static readonly FILTER_PATH = 'filter';
  static readonly FILTERED_PATH = 'filtered';
  static readonly PHONES_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.MOBILE_PHONES_PATH}`;
  static readonly PHONE_MODELS_API_URL = `${ApiConstants.PHONES_API_URL}/${ApiConstants.PHONE_MODELS_PATH}`;
  static readonly PHONE_MODELS_FILTER_API_URL = `${ApiConstants.PHONE_MODELS_API_URL}/${ApiConstants.FILTER_PATH}`;
  static readonly PHONE_MODELS_FILTERED_API_URL = `${ApiConstants.PHONE_MODELS_FILTER_API_URL}/${ApiConstants.FILTERED_PATH}`;
  static readonly MANUFACTURERS_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.MANUFACTURERS_PATH}`;
  static readonly OPERATION_SYSTEMS_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.OPERATION_SYSTEMS_PATH}`;
  static readonly SCREEN_TECHNOLOGIES_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.SCREEN_TECHNOLOGIES}`;
  static readonly OPERATION_SYSTEMS_WITH_VERSIONS_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.OPERATION_SYSTEMS_WITH_VERSIONS_PATH}`;
  static readonly SIM_CARD_TYPES_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.SIM_CARD_TYPES_PATH}`;
  static readonly DUST_AND_MOISTURE_PROTECTION_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.DUST_AND_MOISTURE_PROTECTION_PATH}`;
  static readonly FINGERPRINT_SCANNER_LOCATIONS_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.FINGERPRINT_SCANNER_LOCATIONS_PATH}`;
  static readonly SCREEN_PROTECTIONS_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.SCREEN_PROTECTIONS_PATH}`;
  static readonly GPUS_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.GPUS_PATH}`;
  static readonly MOBILE_GPUS_API_URL = `${ApiConstants.SERVER_API_URL}/mobile-integrated-gpus`;
  static readonly CPUS_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.CPUS_PATH}`;
  static readonly CONNECTION_SOCKETS_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.CONNECTION_SOCKETS_PATH}`;
  static readonly COLORS_API_URL = `${ApiConstants.SERVER_API_URL}/${ApiConstants.COLORS_PATH}`;

}

export class FormControlNames {
  static readonly NAME = 'name';
  static readonly MANUFACTURER = 'manufacturer';
  static readonly MARKET_LAUNCH_YEAR = 'marketLaunchYear';
  static readonly OPERATION_SYSTEM = 'operationSystem';
  static readonly SCREEN_DIAGONAL_IN_INCHES = 'screenDiagonalInInches';
  static readonly HORIZONTAL_SCREEN_RESOLUTION = 'horizontalScreenResolution';
  static readonly VERTICAL_SCREEN_RESOLUTION = 'verticalScreenResolution';
  static readonly SCREEN_TECHNOLOGY = 'screenTechnology';
  static readonly SCREEN_REFRESH_RATE = 'screenRefreshRate';
  static readonly RAM_VARIANTS = 'ramVariants';
  static readonly ROM_VARIANTS = 'romVariants';
  static readonly IS_MEMORY_CARD_SUPPORTED = 'isMemoryCardSupported';
  static readonly CAMERAS_AMOUNT = 'camerasAmount';
  static readonly CAMERA_IN_MP = 'cameraInMp';
  static readonly SIM_CARDS_AMOUNT = 'simCardsAmount';
  static readonly SIM_CARD_TYPE = 'simCardType';
  static readonly IS_5G_SUPPORTED = 'is5GSupported';
  static readonly DUST_AND_MOISTURE_PROTECTION = 'dustAndMoistureProtection';
  static readonly BATTERY_CAPACITY = 'batteryCapacity';
  static readonly FINGERPRINT_SCANNER_LOCATION = 'fingerprintScannerLocation';
  static readonly SCREEN_PROTECTION = 'screenProtection';
  static readonly CPU = 'cpu';
  static readonly HAS_AUDIO_PROCESSOR = 'hasAudioProcessor';
  static readonly FRONT_CAMERA_IN_MP = 'frontCameraInMp';
  static readonly HAS_AUDIO_OUTPUT = 'hasAudioOutput';
  static readonly CONNECTION_SOCKET = 'connectionSocket';
  static readonly LENGTH = 'length';
  static readonly WIDTH = 'width';
  static readonly THICKNESS = 'thickness';
  static readonly WEIGHT = 'weight';
  static readonly BODY_COLORS = 'bodyColors';
}

export class StringConstants {
  static readonly RAM = 'ОЗУ';
  static readonly ROM = 'ПЗУ';
  static readonly GB = 'ГБ';
}
