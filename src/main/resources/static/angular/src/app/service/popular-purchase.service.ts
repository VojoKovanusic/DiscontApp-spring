import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PopularPurchaseService {
  private baseUrl: string = 'http://localhost:8080/api/recent_purchases/';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  constructor(private http: Http) { }

  usersWhoRecentlyPurchased(userName: string) {
    return this.http.get(this.baseUrl + userName, this.options).map((response: Response) => response.json()).
      catch(this.errorHendler);
  }

  errorHendler(error: Response) {
    return Observable.throw(error);
  }
}
