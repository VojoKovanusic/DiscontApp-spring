import { Injectable } from '@angular/core';
import { Response } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Purchas } from '../purchas';

@Injectable()
export class PurchaseService {

  private baseUrl: string = 'http://localhost:8090/api';

  constructor(private httpClient: HttpClient) { }

  allPurchasesByUser(userName: string): Observable<Purchas[]> {
    return this.httpClient.get<Purchas[]>(this.baseUrl + '/purchases/by_user/' + userName)
  }

  peopleWhoPreviouslyPurchasedProduct(id: Number): Observable<Purchas[]> {

    return this.httpClient.get<Purchas[]>(this.baseUrl + '/purchases/by_product/' + id)
  }

}
