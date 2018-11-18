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
import { HomeComponent } from './home/home.component';
import { TaskComponent } from './task/task.component';
import { HowRunComponent } from './how-run/how-run.component';
import { MySolutionComponent } from './my-solution/my-solution.component';
import { AboutAutorComponent } from './about-autor/about-autor.component';
import { AddProductComponent } from './add-product/add-product.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';


const appRoutes: Routes = [
 

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
    HomeComponent,
    TaskComponent,
    HowRunComponent,
    MySolutionComponent,
    AboutAutorComponent,
    AddProductComponent,
    

  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    RouterModule.forRoot([ 
      {
        path:'', 
        component: HomeComponent
      },
      {
        path:'add-update', 
        component: AddProductComponent
      },
      {
        path:'task', 
        component: TaskComponent
      },
      {
        path:'all/product', 
        component: MySolutionComponent
      },
      {
        path:'howToRun', 
        component: HowRunComponent
      },
      {
        path:'mySolution', 
        component: MySolutionComponent
      },
      {
        path:'autor', 
        component: AboutAutorComponent
      },
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