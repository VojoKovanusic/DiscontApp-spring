import { Component, Input } from '@angular/core';
import { Purchas } from './../purchas';
import { PurchaseService } from '../service/purchase.service';
import { error } from 'selenium-webdriver';

@Component({
  selector: 'app-list-purchas',
  templateUrl: './list-purchas.component.html',
  styleUrls: ['./list-purchas.component.css']
})
export class ListPurchasComponent {
  private purchases: Purchas[]=[];
  @Input("id") id: number;
  

  constructor(private service: PurchaseService) { }

  getPurchasesById() {
    this.purchases= [];
    return this.service.peopleWhoPreviouslyPurchasedProduct(this.id)
    .subscribe(purchases => {
      this.purchases = purchases
    },
      error => { console.log(error) });
  }
  getPurchasesByUserName() {
    this.purchases= [];
    return this.service.allPurchasesByUser(this.userName)
    .subscribe(purchases => {
      this.purchases = purchases
    },
      error => { console.log(error) });
  }
  isEmptu(){
    if (this.purchases.length < 1){
    return true;}
    else return false;
  }


}
