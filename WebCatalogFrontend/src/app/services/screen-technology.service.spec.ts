import { TestBed } from '@angular/core/testing';

import { ScreenTechnologyService } from './screen-technology.service';

describe('ScreenTechnologyService', () => {
  let service: ScreenTechnologyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScreenTechnologyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
