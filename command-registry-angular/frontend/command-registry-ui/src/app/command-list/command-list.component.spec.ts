import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandListComponent } from './command-list.component';
import { CommandServiceService } from '../services/command-service.service';
<<<<<<< HEAD
=======
import { MaterialModule } from '../material/material.module';
import { NgxPaginationModule } from 'ngx-pagination';
import { CommandFilterPipe } from '../pipes/command-filter.pipe';
import { FormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
import { CommandMockService } from '../services/command-mock.service';

describe('CommandListComponent', () => {
  let component: CommandListComponent;
  let fixture: ComponentFixture<CommandListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
<<<<<<< HEAD
      declarations: [ CommandListComponent ],
      providers: [
        { provide: CommandServiceService, useClass: CommandMockService }
      ]
=======
      declarations: [ CommandListComponent, CommandFilterPipe ],
      imports: [
        MaterialModule,
        NgxPaginationModule,
        FormsModule,
        HttpClientTestingModule

      ],
      providers: [
        { provide: CommandServiceService, useClass: CommandMockService }
      ]

>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommandListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

<<<<<<< HEAD
  it(`should have 5 commands`, async () => {
    expect(component.commands.length).toEqual(5);
  });

  // it('should create CommandListComponent', () => {
  //   const fixture = TestBed.createComponent(CommandListComponent);
  //   const app = fixture.debugElement.componentInstance;
  //   expect(command-list).toBeTruthy();
  // });

=======

  // it(`should have 5 commands`, async () => {
  //   expect(component.commands.length).toEqual(5);
  // });

  it('should create CommandListComponent', () => {
    expect(component).toBeTruthy();
  });

>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
});
