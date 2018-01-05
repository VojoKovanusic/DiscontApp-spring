import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPurchasComponent } from './list-purchas.component';

describe('ListPurchasComponent', () => {
  let component: ListPurchasComponent;
  let fixture: ComponentFixture<ListPurchasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListPurchasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPurchasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
