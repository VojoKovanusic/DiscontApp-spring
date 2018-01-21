import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutAutorComponent } from './about-autor.component';

describe('AboutAutorComponent', () => {
  let component: AboutAutorComponent;
  let fixture: ComponentFixture<AboutAutorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AboutAutorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutAutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
