import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../service/product.service';
import { error } from 'selenium-webdriver';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-products',
  templateUrl: './all-products.component.html',
  styleUrls: ['./all-products.component.css']
})
/* LIST USER COMPONENET */
export class AllProductsComponent implements OnInit {

  allProducts:Product[]=[];
  constructor(private service:ProductService, private router:Router) { }

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
   
  }
  addProduct(){ 
    let product=new Product();
    this.service.setter(product);
    this.router.navigate(["/add-update"]);
  }
  updateProduct(product){ 
    this.service.setter(product);
   this.router.navigate(["/add-update"]);
  }
}
