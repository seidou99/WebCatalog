import { TestBed } from '@angular/core/testing';

import { PhoneCpuService } from './phone-cpu.service';

describe('CpuService', () => {
  let service: PhoneCpuService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PhoneCpuService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
