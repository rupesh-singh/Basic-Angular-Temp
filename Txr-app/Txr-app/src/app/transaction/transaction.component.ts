import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../transaction.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  constructor(private ts: TransactionService, private fb: FormBuilder) { }

  transactionForm: FormGroup;
  accounts: any = [];
  errors: any = {};
  ngOnInit() {

    this.transactionForm = this.fb.group({
      fromAccNum: ['1', [Validators.required]],
      toAccNum: ['2', [Validators.required]],
      amount: ['', [Validators.required]]
    });

    this.ts.loadProducts().subscribe(e => {
      console.log(e);
      this.accounts = e;
    })

    let authorControl = this.transactionForm.get('amount')
    authorControl.statusChanges.subscribe(e => {
      if (e === 'INVALID') {
        let errors = authorControl.errors;
        if (errors.required) { this.errors['required'] = 'Required' }
        else {
          this.errors['required'] = '';
        }
      }
    })
  }

  handleFormSubmit(event) {
    if (this.transactionForm.valid) {
      this.ts.doTransaction(this.transactionForm.value).subscribe(e => {
        console.log(e);
      })
    }
  }



}
