import { Component, OnInit } from '@angular/core';
import {TransactionService} from '../transaction.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  txn:any=[];
  constructor(private ts: TransactionService) { }
 accounts:any=[];
  ngOnInit() {
    this.ts.loadProducts().subscribe(e=>{
      console.log(e);
      //this.txn=e.transactions;
      this.accounts=e;
    })
  }

}
