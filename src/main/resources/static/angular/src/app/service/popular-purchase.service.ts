import { Injectable } from '@angular/core';
import { Headers, RequestOptions } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { PopularPurchases } from '../popular-purchases';

@Injectable()
export class PopularPurchaseService {

  private baseUrl: string = 'http://localhost:8080/api/recent_purchases/';
  
  constructor(private http: HttpClient) { }

  usersWhoRecentlyPurchased(userName: string): Observable <PopularPurchases > {
    return this.http.get <PopularPurchases >(this.baseUrl + userName)
  
  }
}
