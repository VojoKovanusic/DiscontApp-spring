import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopularPurchaseComponent } from './popular-purchase.component';

describe('PopularPurchaseComponent', () => {
  let component: PopularPurchaseComponent;
  let fixture: ComponentFixture<PopularPurchaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopularPurchaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopularPurchaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
