import { TestBed } from '@angular/core/testing';

import { PhoneModelService } from './phone-model.service';

describe('MobilePhoneModelService', () => {
  let service: PhoneModelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PhoneModelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
