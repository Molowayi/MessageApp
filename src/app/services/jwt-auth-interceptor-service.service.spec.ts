import { TestBed, inject } from '@angular/core/testing';

import { JwtAuthHtppInterceptorService } from './jwt-auth-interceptor-service.service';

describe('JwtAuthHtppInterceptorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [JwtAuthHtppInterceptorService]
    });
  });

  it('should be created', inject([JwtAuthHtppInterceptorService], (service: JwtAuthHtppInterceptorService) => {
    expect(service).toBeTruthy();
  }));
});
