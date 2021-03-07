import { TestBed } from '@angular/core/testing';

import { ScreenProtectionService } from './screen-protection.service';

describe('ScreenProtectionService', () => {
  let service: ScreenProtectionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScreenProtectionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
