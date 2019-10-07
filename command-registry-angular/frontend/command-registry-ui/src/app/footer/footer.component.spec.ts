import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterComponent } from './footer.component';
<<<<<<< HEAD

describe('FooterComponent', () => {
=======
import { MaterialModule } from '../material/material.module';

fdescribe('FooterComponent', () => {
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
  let component: FooterComponent;
  let fixture: ComponentFixture<FooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
<<<<<<< HEAD
      declarations: [ FooterComponent ]
=======

      declarations: [ FooterComponent ],
      imports: [MaterialModule]

>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
