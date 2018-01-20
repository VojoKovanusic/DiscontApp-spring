import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MySolutionComponent } from './my-solution.component';

describe('MySolutionComponent', () => {
  let component: MySolutionComponent;
  let fixture: ComponentFixture<MySolutionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MySolutionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MySolutionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
