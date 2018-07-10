import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  apiUrl: string = "http://localhost:3000/api/products";
  constructor(private http: HttpClient) { }

  loadProducts() {
    return this.http.get(this.apiUrl);

  }


  save(product){

    return this.http.post(this.apiUrl,product);
  }

deletepro(id){
  return this.http.delete(this.apiUrl + `/${id}`)

}

loadProduct(id){

  return this.http.get(this.apiUrl + `/${id}`)
}

update(product){
  return this.http.put(this.apiUrl,product);

}

}
