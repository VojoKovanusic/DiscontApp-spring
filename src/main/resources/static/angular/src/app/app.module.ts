import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';

import { ListPurchasComponent } from './list-purchas/list-purchas.component';
import { Routes, RouterModule } from '@angular/router'
import { PurchaseService } from './service/purchase.service'
import { HttpModule } from '@angular/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PurchaseByUsernameComponent } from './purchase-by-username/purchase-by-username.component';
import { ProductByIdComponent } from './product-by-id/product-by-id.component';
import { ProductService } from './service/product.service';
import { PopularPurchaseService } from './service/popular-purchase.service';
import { PopularPurchaseComponent } from './popular-purchase/popular-purchase.component';
import { AllProductsComponent } from './all-products/all-products.component';
import { LikeComponent } from './like/like.component';

const appRoutes: Routes = [
  { path: '', component: ListPurchasComponent},
  { path: '', component: ProductByIdComponent}

]
@NgModule({
  declarations: [
    AppComponent,
    ListPurchasComponent,
    PurchaseByUsernameComponent,
    ProductByIdComponent,
    PopularPurchaseComponent,
    AllProductsComponent,
    LikeComponent

  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    ReactiveFormsModule
  ],
  providers: [PurchaseService,ProductService,PopularPurchaseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
