import { Component } from '@angular/core';
import { ProductServiceService } from './product-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Shop-IT';
  itemcount: number = 0;
  cart: any = {};
  products: any = [];
  isCartOpen: boolean = false;
  constructor(private productService: ProductServiceService) { }

  ngOnInit() {
    this.productService.loadProducts().subscribe((products) => {
      console.log(products);
      this.products = products;
    });

  }

  addcart(event) {
    // this.item = event.value;
    //this.itemcount++;

    let item = event.item;
    let qty = event.qty;
    let id = item.id;
    let line = this.cart[id];
    if (line) {
      qty = line.qty + 1;
      line = Object.assign({}, line, { qty })
    } else {
      line = Object.assign({ item, qty })
    }
    this.cart = Object.assign({}, this.cart, { [id]: line })
    this.itemcount = Object.keys(this.cart).length;
  }
  toggleCart() {
    this.isCartOpen = !this.isCartOpen;
  }

  clearCart(event) {
    if (event.value === 'clear') {
      this.cart = [];
      this.itemcount = 0;
    }
  }

}
