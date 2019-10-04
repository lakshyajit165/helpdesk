import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ticket } from './ticketinterface';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(
    private http: HttpClient
  ) { }

  getOpenTickets(): Observable<Map<string, object>> {
    return this.http.get<Map<string, object>>('http://localhost:8765/ticketservice/tickets/open');
  }

  changeTicketStatusToEngaged(ticket: Ticket): Observable<object> {
    console.log('inside ticket service');
    return this.http.patch<object>('http://localhost:8765/ticketservice/ticket/status/engage', ticket);
  }

  resolveTicket(ticket: object): Observable<Map<string, object>>{
    return this.http.patch<Map<string, object>>('http://localhost:8765/ticketservice/ticket/status/resolved', ticket);
  }

  callbackMail(ticket: object): Observable<Map<string, object>> {
    return this.http.patch<Map<string, object>>('http://localhost:8765/ticketservice/ticket/status/callbackmail', ticket);

  }
}
