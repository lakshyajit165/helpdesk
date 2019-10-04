import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PerformanceService {

  constructor(
    private http: HttpClient
  ) { }

  getDetailsTaken(): Observable<object> {
    return  this.http.get<object>('http://localhost:8080/tickets/csr/taken');
   }
   getDetailsResolved(): Observable<object> {
    return  this.http.get<object>('http://localhost:8080/tickets/csr/resolved');
   }
}
