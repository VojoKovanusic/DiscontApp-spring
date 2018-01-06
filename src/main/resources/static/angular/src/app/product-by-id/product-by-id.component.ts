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
private products:Product[]=[];
constructor(private service: ProductService) { }

  getProductByID(){
   this.products=[];
    return this.service.getProductByID(this.id)
    .subscribe(products=> {
      this.products=products;
      console.log(this.products);
  },
  error => { console.log(error) })
}
}
