import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductService } from '../product.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {


  productForm: FormGroup;

  constructor(private fb: FormBuilder,
    private productservice: ProductService,
    private router: Router,
    private route: ActivatedRoute) { }

  isEditing: boolean = false;
  originalProduct: any;



  ngOnInit() {
    this.productForm = this.fb.group({
      name: [''],
      price: [''],
      date: [''],
      description: ['']

    });

    this.route.params.subscribe(e => {
      if (e.prodId) {
        this.productservice.loadProduct(e.prodId)
          .subscribe(product => {
            this.originalProduct = product;
            this.productForm.patchValue(product)
            this.isEditing = true;
          })
      }
    })
  }

  handleform(event) {

    event.preventDefault();


    if (this.isEditing) {
      let formData = this.productForm.value;
      let product = Object.assign({}, this.originalProduct, formData)
      this.productservice.update(product)
        .subscribe(product => {
          this.router.navigate(['products'])
        })
      return;
    }


    this.productservice.save(this.productForm.value).subscribe(e => {
      console.log('done');
      this.router.navigate(['products'])
    });



  }

  products: any;



}
