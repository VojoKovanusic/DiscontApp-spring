import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../service/product.service';
import { error } from 'selenium-webdriver';

@Component({
  selector: 'app-all-products',
  templateUrl: './all-products.component.html',
  styleUrls: ['./all-products.component.css']
})
export class AllProductsComponent implements OnInit {

  allProducts:Product[]=[];
  constructor(private service:ProductService) { }

  ngOnInit() {
     return this.service.getAllProduct()
     .subscribe(allProducts=> {
       this.allProducts=allProducts;
       console.log(this.allProducts);
   },
   error => { console.log(error) })
 }
  deleteProduct(product){ 
    this.service.deleteProduct(product.id).subscribe(data=>{
      this.allProducts.splice(this.allProducts.indexOf(product),1);
    }, (error)=>console.log(error));
   this.ngOnInit();
  }
}
