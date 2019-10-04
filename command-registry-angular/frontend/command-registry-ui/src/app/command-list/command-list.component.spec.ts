import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandListComponent } from './command-list.component';
import { CommandServiceService } from '../services/command-service.service';
import { CommandMockService } from '../services/command-mock.service';

describe('CommandListComponent', () => {
  let component: CommandListComponent;
  let fixture: ComponentFixture<CommandListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommandListComponent ],
      providers: [
        { provide: CommandServiceService, useClass: CommandMockService }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommandListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it(`should have 5 commands`, async () => {
    expect(component.commands.length).toEqual(5);
  });

  // it('should create CommandListComponent', () => {
  //   const fixture = TestBed.createComponent(CommandListComponent);
  //   const app = fixture.debugElement.componentInstance;
  //   expect(command-list).toBeTruthy();
  // });

});
