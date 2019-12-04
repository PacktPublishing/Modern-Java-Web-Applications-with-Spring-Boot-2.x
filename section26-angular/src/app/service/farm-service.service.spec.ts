import { TestBed } from '@angular/core/testing';

import { FarmServiceService } from './farm-service.service';

describe('FarmServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FarmServiceService = TestBed.get(FarmServiceService);
    expect(service).toBeTruthy();
  });
});
