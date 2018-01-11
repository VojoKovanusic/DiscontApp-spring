import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-like',
  templateUrl: './like.component.html',
  styleUrls: ['./like.component.css']
})
export class LikeComponent {
  @Input('like') like: boolean;
  private brojac = 0;

  constructor() { }

  naKlikLike() {
    this.brojac += 1;

  }
  naKlikUnLike() {
    this.brojac = this.brojac - 1;
    console.log(this.brojac);
  }
}
