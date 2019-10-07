import { Component, OnInit } from '@angular/core';

<<<<<<< HEAD
=======
import { TrackIssueService } from '../services/track-issue.service';
import { ReportInterface } from '../model/ReportInterface';


>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
@Component({
  selector: 'app-track-issue',
  templateUrl: './track-issue.component.html',
  styleUrls: ['./track-issue.component.css']
})
export class TrackIssueComponent implements OnInit {

<<<<<<< HEAD
  constructor() { }

  ngOnInit() {
=======
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

>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
  }

}
