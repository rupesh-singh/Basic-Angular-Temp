import { Component, OnInit, Input,Output,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-view-cart',
  templateUrl: './view-cart.component.html',
  styleUrls: ['./view-cart.component.css']
})
export class ViewCartComponent implements OnInit {
  @Input() cart;
  itemsLine: Array<any> = [];

  @Output()
  clear=new EventEmitter();
  
  totalAmount: number = 0.0;

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges() {
    let keys = Object.keys(this.cart);
    this.itemsLine = [];
    this.totalAmount = 0.0;
    keys.forEach(key => {
      let line = this.cart[key];
      this.itemsLine.push(line)
      this.totalAmount += line.item.price * line.qty;
      
    })
  }

  isCartEmpty(){

    if(this.itemsLine.length===0)
    return true;
    else
    false;
  }

  clearCart(event){
    this.itemsLine=[];
    this.totalAmount=0;
    this.clear.emit({value:'clear' });


  }
  increaseQuantity(){
   this.cart.qty=this.cart.qty+1;
  //  this.ngOnChanges();
   this.clear.emit({value:this.cart});

  }

}

