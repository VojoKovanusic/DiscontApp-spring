import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Route, Router } from '@angular/router'
import { Product } from '../product';
import { error } from 'selenium-webdriver';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
/* USER FORM COMPONENT */
export class AddProductComponent implements OnInit {
private product:Product;
  constructor(private productService:ProductService, private router: Router) { }
 
  ngOnInit() {
    this.product=this.productService.getter();  
  }
  processFormOnSubmit(){
    console.log("usao-processFormOnSubmit()-create")
    if(this.product.id==undefined){
      this.productService.addProduct(this.product).subscribe(
        (user)=>
        {
        console.log(user),
        this.router.navigate(["/all/product"]),
        (error)=>
        {console.log(error)}
      } 
    )
    }
    else{
      console.log("usao-processFormOnSubmit()-update")
      this.productService.updateProduct(this.product).subscribe(
        (user)=>
        {
        console.log(user),
        this.router.navigate(["/all/product"]),
        (error)=>
        {console.log(error)}
      } 
    )
    }
  }
}
