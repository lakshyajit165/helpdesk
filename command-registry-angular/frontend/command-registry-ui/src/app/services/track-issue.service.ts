import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ReportInterface } from '../model/ReportInterface';
import { ReportResponse } from '../model/ReportResponse';

@Injectable({
  providedIn: 'root'
})
export class TrackIssueService {

  private url = '/assets/data/report.json';
    //  private url = 'http://spring-boot-command-registry:8082/api/v1/commandregistry/commands';
    //  private url = 'http://localhost:8082/api/v1/commandregistry/commands';

    constructor(private httpClient: HttpClient) { }

    getReport(): Observable<ReportResponse> {
       return this.httpClient.get<ReportResponse>(this.url);
    }
}
