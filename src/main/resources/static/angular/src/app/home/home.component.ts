import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
img:string;
  constructor() { }

  ngOnInit() {
     this.img="http://www.automotiveengineeringhq.com/wp-content/uploads/2014/12/Project-manager.jpg";
}

}
