import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {RouterModule, Routes} from '@angular/router';
import { AccountComponent } from './account/account.component';
import { TransactionComponent } from './transaction/transaction.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SummaryComponent } from './summary/summary.component';

const routes:Routes=[
  {path: '', component: HomeComponent},
  {path:'account', component: AccountComponent },
  {path:'txr', component: TransactionComponent },
  {path:'summary', component: SummaryComponent }

];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AccountComponent,
    TransactionComponent,
    SummaryComponent
   
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
