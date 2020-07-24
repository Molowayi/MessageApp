import { TestBed, inject } from '@angular/core/testing';

import { JwtAuthInterceptorServiceService } from './jwt-auth-interceptor-service.service';

describe('JwtAuthInterceptorServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [JwtAuthInterceptorServiceService]
    });
  });

  it('should be created', inject([JwtAuthInterceptorServiceService], (service: JwtAuthInterceptorServiceService) => {
    expect(service).toBeTruthy();
  }));
});
