import { TestBed, inject } from '@angular/core/testing';

import { BasicAuthHtppInterceptorService } from './basic-auth-http-interceptor-service.service';

describe('BasicAuthHtppInterceptorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BasicAuthHtppInterceptorService]
    });
  });

  it('should be created', inject([BasicAuthHtppInterceptorService], (service: BasicAuthHtppInterceptorService) => {
    expect(service).toBeTruthy();
  }));
});
