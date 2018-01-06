import { Component,Input } from '@angular/core';
import { PopularPurchases } from '../popular-purchases';
import { PopularPurchaseService } from '../service/popular-purchase.service';

@Component({
  selector: 'app-popular-purchase',
  templateUrl: './popular-purchase.component.html',
  styleUrls: ['./popular-purchase.component.css']
})
export class PopularPurchaseComponent{
  private purchases: PopularPurchases[]=[];
  @Input("id") id: number;
  constructor(private service:PopularPurchaseService) { }

  usersWhoRecentlyPurchased(userName: string) {
    return this.service
  }
}
