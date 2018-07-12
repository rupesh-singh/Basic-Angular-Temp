import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.css']
})
export class SummaryComponent implements OnInit {

  transaction: any = [];
  constructor(private ts: TransactionService) { }

  ngOnInit() {
   

  }

  handleSubmit(event){
    this.ts.loadTxr().subscribe(response => {
      console.log(response);
      this.transaction = response;

    })

  }
}
