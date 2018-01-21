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

import { hasLifecycleHook } from '@angular/compiler/src/lifecycle_reflector';
import { getDebugNode } from '@angular/core/src/debug/debug_node';
import { formGroupNameProvider } from '@angular/forms/src/directives/reactive_directives/form_group_name';
import { HomeComponent } from './home/home.component';
import { TaskComponent } from './task/task.component';
import { HowRunComponent } from './how-run/how-run.component';
import { MySolutionComponent } from './my-solution/my-solution.component';
import { AboutAutorComponent } from './about-autor/about-autor.component';


const appRoutes: Routes = [
/* { path: '', component: ListPurchasComponent},
  { path: '', component: ProductByIdComponent}  */

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
    AboutAutorComponent

  ],
  imports: [
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
        path:'task', 
        component: TaskComponent
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