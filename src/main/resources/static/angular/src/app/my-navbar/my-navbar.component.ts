import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-my-navbar',
  templateUrl: './my-navbar.component.html',
  styleUrls: ['./my-navbar.component.css']
})
export class MyNavbarComponent implements OnInit {
  img: string;
  constructor() {
    this.img = "https://static1.squarespace.com/static/56437db0e4b0a6089932a7e8/t/57af1f94cd0f683c60af637e/1471094701974/june-mango-branding-design-portfolio.png";
  }
  ngOnInit() {
  }

}
