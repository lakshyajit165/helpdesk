import { Component, OnInit } from '@angular/core';
import { TicketService } from '../services/ticket.service';
import { Ticket } from '../model/ticketinterface';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-opentickets',
  templateUrl: './opentickets.component.html',
  styleUrls: ['./opentickets.component.css']
})
export class OpenticketsComponent implements OnInit {

  responseObject: object;
  closeTickets: object[];
  engagedTickets: object[];
  tickets: object[];
  tags: [];


  constructor(
    private ticketService: TicketService,
    private router: Router
  ) {

  }

  ngOnInit() {
    this.ticketService.getOpenTickets().subscribe(res => {
      console.log(res);
      this.responseObject = res;
      this.extractData(this.responseObject);


    },
    (err) => {
      console.log(err);
    });
  }

  extractData(responseObject: object) {
    for (const key of Object.keys(responseObject)) {
      if (key === 'result') {
        this.tickets = responseObject[key];
      }

    }

  }

  assignMeClicked(ticket: Ticket) {
    this.router.navigate([`/ticket/${ticket.id}`], { state: { ticket }});
  }

}
