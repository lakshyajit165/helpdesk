import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ticket } from '../model/ticketinterface';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(
    private http: HttpClient
  ) { }

  getOpenTickets(): Observable<object> {
   // return this.http.get<Map<string, object>>('http://localhost:8765/ticketservice/tickets/open');
   return this.http.get<object>('http://localhost:8765/ticket-service/tickets/open');
  }

  changeTicketStatusToEngaged(ticket: Ticket): Observable<object> {
    // console.log('inside ticket service');
    return this.http.patch<object>('http://localhost:8765/ticket-service/tickets/status/engaged', ticket);
  }

  resolveTicket(ticket: Ticket): Observable<object> {
    return this.http.patch<object>('http://localhost:8765/ticket-service/tickets/status/resolved', ticket);
  }

  callbackMail(ticket: Ticket): Observable<object> {
    return this.http.patch<object>('http://localhost:8765/ticket-service/tickets/status/callbackmail', ticket);

  }

  // getClosedTickets(): Observable<object> {
  //   return this.http.get<Map<string, object>>('http://localhost:8765/ticket-service/tickets/closed');
  // }

  // getEngagedTickets(): Observable<object> {
  //   return this.http.get<Map<string, object>>('http://localhost:8765/ticket-service/tickets/engaged');
  // }

}
