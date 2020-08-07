import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {Addres} from '../model/model.addres';
import {throwError} from 'rxjs/index';
import {catchError} from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {

  url = '';

  constructor(private httpClient: HttpClient) {
  }

  enroll<T>(t: T) {
    return this.httpClient.post<T>(this.url, t).pipe(catchError(this.errorHandler));
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}



// import { Injectable } from '@angular/core';
//
// @Injectable({
//   providedIn: 'root'
// })
// export class EnrollmentService {
//
//   constructor() { }
// }
