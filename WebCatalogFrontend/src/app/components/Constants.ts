export class Constants {
  static readonly SERVER_HOST = 'http://localhost';
  static readonly SERVER_PORT = '8080';
  static readonly SERVER_API_PATH = 'api';
  static readonly SERVER_API_URL = `${Constants.SERVER_HOST}:${Constants.SERVER_PORT}/${Constants.SERVER_API_PATH}`;
  static readonly MOBILE_PHONES_PATH = 'phones';
  static readonly MOBILE_PHONE_MANUFACTURERS_PATH = 'manufacturers';
  static readonly MOBILE_PHONES_API_URL = `${Constants.SERVER_API_URL}/${Constants.MOBILE_PHONES_PATH}`;
  static readonly MOBILE_PHONE_MANUFACTURERS_API_URL = `${Constants.MOBILE_PHONES_API_URL}/${Constants.MOBILE_PHONE_MANUFACTURERS_PATH}`;
}
