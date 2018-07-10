import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor(private productService: ProductService ) { }

  products:any;


  ngOnInit() {
    this.productService.loadProducts()
    .subscribe(products=>this.products=products);
  }

  deleteEntry(id){
    this.productService.deletepro(id).subscribe(resp=>{
      console.log('done2');
      this.products=this.products.filter(item=>item.id!==id)
    })

  }





  
}
