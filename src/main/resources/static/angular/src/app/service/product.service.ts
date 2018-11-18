import { Injectable, OnInit } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Observable } from 'rxjs/Observable';
import { Product } from '../product';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ProductService implements OnInit {

  private baseUrl: string = 'http://localhost:8080/api/products/';
  private productUrl: string = 'http://localhost:8080/product/';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  private product: Product;
  constructor(private http: Http,private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.getAllProduct();
  }
  getProductByID(id: number) : Observable<Product>{
   
    return this.httpClient.get<Product>(this.baseUrl + id) ;
  }

  getAllProduct() : Observable<Product[]> {
     
    return this.httpClient.get<Product[]>(this.baseUrl) 
  }

  errorHendler(error: Response) {
    return Observable.throw(error);
  }

  deleteProduct(id: number) {
    return this.http.delete(this.productUrl + id, this.options).map((response: Response) => response.json()).
      catch(this.errorHendler);
  }

  updateProduct(product: Product) {
    console.log("usao updateProduct")
    return this.http.put(this.productUrl, JSON.stringify(product), this.options).map((response: Response) => response.json()).
      catch(this.errorHendler);
  }
  addProduct(product: Product) {
    return this.http.post(this.productUrl, JSON.stringify(product), this.options).map((response: Response) => response.json()).
      catch(this.errorHendler);
  }
  setter(product:Product) {
    this.product = product;

  }
  getter() {
    return this.product;
  }
}
