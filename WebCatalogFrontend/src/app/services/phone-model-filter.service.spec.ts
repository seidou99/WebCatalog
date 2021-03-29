import { TestBed } from '@angular/core/testing';

import { PhoneModelFilterService } from './phone-model-filter.service';

describe('PhoneModelFilterService', () => {
  let service: PhoneModelFilterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PhoneModelFilterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
