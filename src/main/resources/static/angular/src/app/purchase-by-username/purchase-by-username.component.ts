import { Component, Input } from '@angular/core';
import { Purchas } from './../purchas';
import { PurchaseService } from '../service/purchase.service';
import { error } from 'selenium-webdriver';

@Component({
  selector: 'app-purchase-by-username',
  templateUrl: './purchase-by-username.component.html',
  styleUrls: ['./purchase-by-username.component.css']
})
export class PurchaseByUsernameComponent  {
  @Input("userName") userName:string;
  private purchases: Purchas[]=[];
  
  constructor(private service: PurchaseService) { }

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
