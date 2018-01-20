import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-my-navbar',
  templateUrl: './my-navbar.component.html',
  styleUrls: ['./my-navbar.component.css']
})
export class MyNavbarComponent implements OnInit {
  img: string;
  constructor() {
    this.img="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThctW_aDu1WU6igXgbJ2qBOkyac4aj5fEIxFEIZzm1KN5eh9SyzQ"
  }
  ngOnInit() {
    
  }

}
