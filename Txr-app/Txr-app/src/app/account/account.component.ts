import { Component, OnInit } from '@angular/core';
import {TransactionService} from '../transaction.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  constructor(private ts: TransactionService) { }
 accounts:any=[];
  ngOnInit() {
    this.ts.loadProducts().subscribe(e=>{
      console.log(e);
      this.accounts=e;
    })
  }

}
