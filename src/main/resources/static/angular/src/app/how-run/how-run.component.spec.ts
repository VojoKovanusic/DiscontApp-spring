import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HowRunComponent } from './how-run.component';

describe('HowRunComponent', () => {
  let component: HowRunComponent;
  let fixture: ComponentFixture<HowRunComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HowRunComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HowRunComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
