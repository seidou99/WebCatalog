import { TestBed } from '@angular/core/testing';

import { FingerprintScannerLocationService } from './fingerprint-scanner-location.service';

describe('FingerprintScannerLocationService', () => {
  let service: FingerprintScannerLocationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FingerprintScannerLocationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
