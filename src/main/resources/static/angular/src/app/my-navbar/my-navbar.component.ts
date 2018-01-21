import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-my-navbar',
  templateUrl: './my-navbar.component.html',
  styleUrls: ['./my-navbar.component.css']
})
export class MyNavbarComponent implements OnInit {
  img: string;
  constructor() {
    this.img="https://image.freepik.com/vector-gratis/fachada-de-tienda-plana-con-toldo_23-2147542588.jpg"
  }
  ngOnInit() {
    
  }

}
