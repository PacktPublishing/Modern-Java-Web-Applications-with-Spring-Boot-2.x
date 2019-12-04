import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import {  Profile } from '../model/profile';

import { catchError, tap, map } from 'rxjs/operators';
import { Observable, of, throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class FarmServiceService {

  uriPost = 'farmservice/signup/user/add';
  uriGet = 'farmservice/signup/users';

  httpOptions = {
    headers: new HttpHeaders({
     'Access-Control-Allow-Headers': ['Content-Type', 'Authorization', 'X-Auth-Token'],
     'Access-Control-Allow-Methods': ['GET', 'POST', 'PUT', 'DELETE'],
     'Access-Control-Allow-Origin': '*',
     'Accept': 'application/json, */*',
     'Content-Type': 'application/json',
   } )
 }

  constructor(private http: HttpClient) { }

  addProfileUser(profile: Profile) {
    console.log(profile);
    this.http.post(`${this.uriPost}`, profile)
        .subscribe(res => console.log('Done'));
  }



  getUsers(): Observable<any> {
     return this.http.get( this.uriGet, this.httpOptions).pipe(
        tap(profile => console.log('fetched products')),
        catchError(this.handleError('getProducts', []))
    );

  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
