import { TestBed, inject } from '@angular/core/testing';

import { BasicAuthHttpInterceptorServiceService } from './basic-auth-http-interceptor-service.service';

describe('BasicAuthHttpInterceptorServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BasicAuthHttpInterceptorServiceService]
    });
  });

  it('should be created', inject([BasicAuthHttpInterceptorServiceService], (service: BasicAuthHttpInterceptorServiceService) => {
    expect(service).toBeTruthy();
  }));
});
