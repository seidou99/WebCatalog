import { TestBed } from '@angular/core/testing';

import { OperationSystemService } from './operation-system.service';

describe('MobilePhoneOperationSystemService', () => {
  let service: OperationSystemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OperationSystemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
