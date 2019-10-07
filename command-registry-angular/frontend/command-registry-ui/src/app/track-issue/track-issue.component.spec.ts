import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackIssueComponent } from './track-issue.component';

<<<<<<< HEAD
=======
import { MaterialModule } from '../material/material.module';
import { FormsModule } from '@angular/forms';
import { IssueFilterPipe } from '../pipes/issue-filter.pipe';
import { IntentFilterPipe } from '../pipes/intent-filter.pipe';
import { NgxPaginationModule } from 'ngx-pagination';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
describe('TrackIssueComponent', () => {
  let component: TrackIssueComponent;
  let fixture: ComponentFixture<TrackIssueComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
<<<<<<< HEAD
      declarations: [ TrackIssueComponent ]
=======

      declarations: [ TrackIssueComponent, IssueFilterPipe,
        IntentFilterPipe ],
      imports: [MaterialModule, FormsModule, NgxPaginationModule, HttpClientModule, BrowserAnimationsModule]
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackIssueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
