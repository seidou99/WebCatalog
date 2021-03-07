import { TestBed } from '@angular/core/testing';

import { DustAndMoistureProtectionService } from './dust-and-moisture-protection.service';

describe('DustAndMoistureProtectionService', () => {
  let service: DustAndMoistureProtectionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DustAndMoistureProtectionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
