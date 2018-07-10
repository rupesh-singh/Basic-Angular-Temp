import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  constructor() { }


  @Input()
review:any;

stars: Array<number>;

  ngOnInit() {
    this.stars=new Array(this.review.stars);
  }

}
