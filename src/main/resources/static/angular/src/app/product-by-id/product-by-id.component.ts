import { Component, Input } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Product } from '../product';
import { error } from 'selenium-webdriver';

@Component({
  selector: 'app-product-by-id',
  templateUrl: './product-by-id.component.html',
  styleUrls: ['./product-by-id.component.css']
})
export class ProductByIdComponent {
@Input("id")id:number;
private product:Product;
constructor(private service: ProductService) { }

  getProductByID(){
   this.product=new Product();
    return this.service.getProductByID(this.id)
    .subscribe(product=> {
      this.product=product;
      console.log(this.product);
  },
  error => { console.log(error) })
}
isNull(){
  if (this.product.isNull)
  return true;
}
}
