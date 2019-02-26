import { TestBed, inject } from '@angular/core/testing';

import { ServiceforallService } from './serviceforall.service';

describe('ServiceforallService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServiceforallService]
    });
  });

  it('should be created', inject([ServiceforallService], (service: ServiceforallService) => {
    expect(service).toBeTruthy();
  }));
});
