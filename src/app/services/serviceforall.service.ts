import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceforallService {

  constructor(private httpClient: HttpClient) {
  }

  post<T>(url: string, t: T, httpOptions: any) {
    return this.httpClient.post<T>(url, t, httpOptions).pipe(catchError(this.errorHandler));
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }

  get<T>(url: string, httpOptions: any) {
    return this.httpClient.get<T>(url, httpOptions).pipe(catchError(this.errorHandler));
  }

}
