import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchaseByUsernameComponent } from './purchase-by-username.component';

describe('PurchaseByUsernameComponent', () => {
  let component: PurchaseByUsernameComponent;
  let fixture: ComponentFixture<PurchaseByUsernameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchaseByUsernameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchaseByUsernameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
