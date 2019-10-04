import { Component, OnInit } from '@angular/core';

import { TrackIssueService } from '../services/track-issue.service';
import { ReportInterface } from '../model/ReportInterface';


@Component({
  selector: 'app-track-issue',
  templateUrl: './track-issue.component.html',
  styleUrls: ['./track-issue.component.css']
})
export class TrackIssueComponent implements OnInit {

  report: ReportInterface[];

  step = 0;

  setStep(index: number) {
    this.step = index;
  }

  nextStep() {
    this.step++;
  }

  prevStep() {
    this.step--;
  }



  constructor(private trackIssueService: TrackIssueService) { }

  ngOnInit() {
    this.trackIssueService.getReport()
        .subscribe(data => {
          this.report = data.result;
          console.log(this.report);
        });

  }

}
