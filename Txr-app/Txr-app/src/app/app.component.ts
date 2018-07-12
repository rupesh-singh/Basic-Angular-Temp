import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';


  currentTab: number = 0;

  isTabSelected(idx) {
    return this.currentTab === idx;
  }
  changeTab(event,idx){
    this.currentTab=idx;
  }
}
