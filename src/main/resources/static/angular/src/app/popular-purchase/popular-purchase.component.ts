import { Component, Input } from '@angular/core';
import { PopularPurchases } from '../popular-purchases';
import { PopularPurchaseService } from '../service/popular-purchase.service';
import { error } from 'selenium-webdriver';
import { Product } from '../product';

@Component({
  selector: 'app-popular-purchase',
  templateUrl: './popular-purchase.component.html',
  styleUrls: ['./popular-purchase.component.css']
})
export class PopularPurchaseComponent {
  private product: Product;
  private recentUserNames: string[];
  private purchase=new PopularPurchases(this.product, this.recentUserNames);
  private list:PopularPurchases;
  @Input("userName") userName: string;
  constructor(private service: PopularPurchaseService) { }

  usersWhoRecentlyPurchased() {
    return this.service.usersWhoRecentlyPurchased(this.userName)
      .subscribe(list => { 
        this.list = list
    console.log(this.list)
  },
  error => console.log(error));
  }
  isEmptu(){
    
    if (this.purchase== null){
    return true;}
    else return false;

  }
  
}