import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormComponent } from './form.component';
<<<<<<< HEAD
=======
import { MaterialModule } from '../material/material.module';
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69

describe('FormComponent', () => {
  let component: FormComponent;
  let fixture: ComponentFixture<FormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
<<<<<<< HEAD
      declarations: [ FormComponent ]
=======

      declarations: [ FormComponent ],
      imports: [
        MaterialModule
      ]
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
