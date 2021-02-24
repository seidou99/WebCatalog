import { TestBed } from '@angular/core/testing';

import { MobilePhoneManufacturerService } from './mobile-phone-manufacturer.service';

describe('MobilePhoneManufacturerServiceService', () => {
  let service: MobilePhoneManufacturerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MobilePhoneManufacturerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
