import { TestBed } from '@angular/core/testing';

import { SimCardTypeService } from './sim-card-type.service';

describe('SimCardTypeServiceService', () => {
  let service: SimCardTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SimCardTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
