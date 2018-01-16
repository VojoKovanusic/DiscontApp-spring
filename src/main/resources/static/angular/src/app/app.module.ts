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
import { MyNavbarComponent } from './my-navbar/my-navbar.component';
import { NotfoundComponentComponent } from './notfound-component/notfound-component.component';
import { getHashes, DEFAULT_ENCODING } from 'crypto';
import { SSL_OP_MICROSOFT_BIG_SSLV3_BUFFER } from 'constants';
import { hasLifecycleHook } from '@angular/compiler/src/lifecycle_reflector';
import { getDebugNode } from '@angular/core/src/debug/debug_node';
import { formGroupNameProvider } from '@angular/forms/src/directives/reactive_directives/form_group_name';
import { HomeComponent } from './home/home.component';

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
    LikeComponent,
    MyNavbarComponent,
    NotfoundComponentComponent,
    HomeComponent

  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    /* RouterModule.forRoot(appRoutes), */
    RouterModule.forRoot([ 
      {
        path:'', 
        component: HomeComponent
      },
    {
      path:'products', 
      component: AllProductsComponent
    },
    {
      path:'list/purchas', 
      component: ListPurchasComponent
    },
    {
      path:'purchasebyusername/:username',
      component: PurchaseByUsernameComponent
    }
    ,
    {
      path:'**',
      component: NotfoundComponentComponent 
    }
    ]),
    ReactiveFormsModule
  ],
  providers: [PurchaseService,ProductService,PopularPurchaseService],
  bootstrap: [AppComponent]
})
export class AppModule { }