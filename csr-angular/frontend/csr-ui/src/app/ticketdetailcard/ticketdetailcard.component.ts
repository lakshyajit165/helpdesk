import { Component, OnInit } from '@angular/core';
import { Ticket } from '../model/ticketinterface';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { TicketService } from '../services/ticket.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-ticketdetailcard',
  templateUrl: './ticketdetailcard.component.html',
  styleUrls: ['./ticketdetailcard.component.css']
})
export class TicketdetailcardComponent implements OnInit {

  private ticket: Ticket;
  private status: string;
  private stat = 'status';
  private result = 'result';

  constructor(
    private router: Router,
    private http: HttpClient,
    private ticketService: TicketService,
    private snackbar: MatSnackBar
  ) { 
    if (this.router.getCurrentNavigation().extras.state !== undefined) {
      this.ticket = this.router.getCurrentNavigation().extras.state.ticket;
      this.updateTicketStatusToEngaged(this.ticket);
      this.status = 'Engaged';
    }
  }

  ngOnInit() {

  }

  updateTicketStatusToEngaged(ticket: Ticket) {

    this.ticketService.changeTicketStatusToEngaged(ticket).subscribe(res => {
    console.log(res);

    });

  }

  resolveTicket(message: string, action: string) {
    
    // console.log(id);
   
    this.ticketService.resolveTicket(this.ticket).subscribe(res => {
      this.snackbar.open(message, action, { duration: 4000 });
      console.log(res);
      this.router.navigate(['/home']);
    });
    
  }

  generateCallbackMail(message: string, action: string) {
   
    this.ticketService.callbackMail(this.ticket).subscribe(res => {
      console.log(res);
      this.snackbar.open(message, action, { duration: 4000 });
      this.router.navigate(['/home']);
    });
    
  }

}
