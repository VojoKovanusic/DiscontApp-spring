import { Component, Input } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Product } from '../product';
import { error } from 'selenium-webdriver';
import { Validators, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-product-by-id',
  templateUrl: './product-by-id.component.html',
  styleUrls: ['./product-by-id.component.css']
})
export class ProductByIdComponent {
  @Input('id') id: number;
  private product: Product;
  form = new FormGroup({
    id: new FormControl('', [
      Validators.required,
      Validators.minLength(5)
    ])
  });
  constructor(private service: ProductService) { }

  getProductByID() {
    this.product = new Product();
    return this.service.getProductByID(this.id)
      .subscribe(product => {
        this.product = product;
        console.log(this.product);
      },
      // tslint:disable-next-line:no-shadowed-variable
      error => { console.log(error); });
  }
  isNull() {
    // tslint:disable-next-line:curly
    if (this.product.isNull)
      return true;
  }
  get idF() {
    return this.form.get('id');

  }

}
