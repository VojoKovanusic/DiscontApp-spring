import { Component, Input } from '@angular/core';
import { Purchas } from './../purchas';
import { PurchaseService } from '../service/purchase.service';
import { error } from 'selenium-webdriver';
import { FormGroup, FormControl,Validators } from '@angular/forms';

@Component({
  selector: 'app-list-purchas',
  templateUrl: './list-purchas.component.html',
  styleUrls: ['./list-purchas.component.css']
})
export class ListPurchasComponent {
  private purchases: Purchas[] = [];
  @Input("id") id: number;
  form = new FormGroup({
    id: new FormControl('', [
      Validators.required,
    ])
  });

  constructor(private service: PurchaseService) { }

  getPurchasesById() {
    this.purchases = [];
    return this.service.peopleWhoPreviouslyPurchasedProduct(this.id)
      .subscribe(purchases => {
        this.purchases = purchases
      },
      error => { console.log(error) });
  }

  isEmptu() {
    if (this.purchases.length < 1) {
      return true;
    }
    else return false;
  }

get idF(){
  return this.form.get('id');
} 
}
