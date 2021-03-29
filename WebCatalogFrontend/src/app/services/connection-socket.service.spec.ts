import { TestBed } from '@angular/core/testing';

import { ConnectionSocketService } from './connection-socket.service';

describe('ConnectionSocketService', () => {
  let service: ConnectionSocketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConnectionSocketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
