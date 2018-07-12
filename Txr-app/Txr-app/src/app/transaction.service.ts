import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http:HttpClient) { }
  apiUrl="http://localhost:8080/api/account";

  loadProducts() {
    return this.http.get(this.apiUrl)
  }

doTransaction(newTrans){
  return this.http.post("http://localhost:8080/api/txr",newTrans);

}

}
