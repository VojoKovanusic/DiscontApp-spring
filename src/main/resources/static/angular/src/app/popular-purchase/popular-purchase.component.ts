import { Component, Input } from '@angular/core';
import { PopularPurchases } from '../popular-purchases';
import { PopularPurchaseService } from '../service/popular-purchase.service';
import { error } from 'selenium-webdriver';

@Component({
  selector: 'app-popular-purchase',
  templateUrl: './popular-purchase.component.html',
  styleUrls: ['./popular-purchase.component.css']
})
export class PopularPurchaseComponent {
  private purchase: PopularPurchases;
  @Input("userName") userName: string;
  constructor(private service: PopularPurchaseService) { }

  usersWhoRecentlyPurchased() {
    return this.service.usersWhoRecentlyPurchased(this.userName)
      .subscribe(purchase => { 
        this.purchase = purchase
    console.log(this.purchase)
  },
  error => console.log(error));
  }
}