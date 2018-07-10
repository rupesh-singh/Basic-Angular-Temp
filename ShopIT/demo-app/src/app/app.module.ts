import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { ProductModelComponent } from './product-model/product-model.component';
import { ReviewComponent } from './review/review.component';
import { ReviewFormComponent } from './review-form/review-form.component';
import { ProductServiceService } from './product-service.service';
import { ViewCartComponent } from './view-cart/view-cart.component';
@NgModule({
  declarations: [
    AppComponent,
    ProductModelComponent,
    ReviewComponent,
    ReviewFormComponent,
    ViewCartComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [
    ProductServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
