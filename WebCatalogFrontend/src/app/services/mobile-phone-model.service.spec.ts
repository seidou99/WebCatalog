import { TestBed } from '@angular/core/testing';

import { MobilePhoneModelService } from './mobile-phone-model.service';

describe('MobilePhoneModelService', () => {
  let service: MobilePhoneModelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MobilePhoneModelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
