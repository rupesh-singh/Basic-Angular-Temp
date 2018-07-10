import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { ProductServiceService } from '../product-service.service';


@Component({
  selector: 'app-product-model',
  templateUrl: './product-model.component.html',
  styleUrls: ['./product-model.component.css']
})
export class ProductModelComponent implements OnInit {

  tabNumber: number = 1;
  @Input()
  idx: number;
  item: number;
  cart: FormGroup;
  @Input()
  product: any;
  @Output()
  new = new EventEmitter();
  constructor(private productService: ProductServiceService) { }

  reviews: any = [];



  ngOnInit() {

  }


  changeTab(event, idx) {
    this.tabNumber = idx;
    if (idx === 3) {
      this.productService.loadReviews(this.product.id).subscribe(reviews => {
        this.reviews = reviews;
      })
    }

  }

  isTabSelected(idx) {
    return this.tabNumber === idx;

  }

  handlesubmit(event) {
    this.reviews.push(event.value);
    this.productService.addreviews(this.product.id,event.value).subscribe(e=>{
      this.reviews.push(e);
      console.log(e);
    })
  }
  addcart(event) {
    let qty = 1;
    this.new.emit({ item: this.product, qty});

  }



}
