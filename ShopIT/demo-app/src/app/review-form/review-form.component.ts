import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup, ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';


@Component({
  selector: 'app-review-form',
  templateUrl: './review-form.component.html',
  styleUrls: ['./review-form.component.css']
})
export class ReviewFormComponent implements OnInit {

  @Output()
  onNewReview = new EventEmitter();

  errorMessage: any = {};
  reviewForm: FormGroup;

  constructor(private fb: FormBuilder) {

  }


  ngOnInit() {
    this.reviewForm = this.fb.group({
      stars: ['5', [Validators.required, Validators.min(3)]],
      author: ['', [Validators.required, Validators.minLength(3)]],
      body: ['', [Validators.required, Validators.minLength(5)]]
    });

    let authorControl = this.reviewForm.get('author')
    authorControl.statusChanges
      .subscribe(e => {
        if (e === 'INVALID') {
          this.errorMessage = authorControl.errors;
          if (this.errorMessage.required) { this.errorMessage.required = 'Required' }
          if (this.errorMessage.minLength) { this.errorMessage.required = 'min character required' }

        }
      });


  }

  showFormBtn: boolean = false;

  showForm(event) {
    this.showFormBtn = !this.showFormBtn;
  }


  handleSubmit(e) {
    //console.log("hello here");
    e.preventDefault();
    if (this.reviewForm.valid) {
      //console.log("valid bc");
      let review = this.reviewForm.value;
      this.onNewReview.emit({ value: review });
      this.showForm(event);
    }


  }
}
