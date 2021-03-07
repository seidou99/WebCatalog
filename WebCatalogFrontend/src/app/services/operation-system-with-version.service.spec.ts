import { TestBed } from '@angular/core/testing';

import { OperationSystemWithVersionService } from './operation-system-with-version.service';

describe('OperationSystemWithVersionService', () => {
  let service: OperationSystemWithVersionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OperationSystemWithVersionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
