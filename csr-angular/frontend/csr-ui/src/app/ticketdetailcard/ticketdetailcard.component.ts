import { Component, OnInit, Inject } from '@angular/core';
import { Ticket } from '../model/ticketinterface';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { TicketService } from '../services/ticket.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

export interface DialogData {
  reportReason: string;
}

@Component({
  selector: 'dialog-overview-example-dialog',
  templateUrl: 'reportuserdialog.html',
})
export class DialogOverviewExampleDialog {

  private reportReason;


  constructor(
    public dialogRef: MatDialogRef<DialogOverviewExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}


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
  private command: string;
  
  constructor(
    private router: Router,
    private http: HttpClient,
    private ticketService: TicketService,
    private snackbar: MatSnackBar,
    public dialog: MatDialog
  ) {
    if (this.router.getCurrentNavigation().extras.state !== undefined) {
      this.ticket = this.router.getCurrentNavigation().extras.state.ticket;
      this.updateTicketStatusToEngaged(this.ticket);
      this.status = 'Engaged';
    }
  }

  ngOnInit() {

  }

  // Open the dialog box
  openDialog(): void {
    const dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '400px',
     // data: {name: this.name, animal: this.animal}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);

    });
  }

  updateTicketStatusToEngaged(ticket: Ticket) {

    this.ticketService.changeTicketStatusToEngaged(ticket).subscribe(res => {
    console.log(res);

    });

  }

  resolveTicket(message: string, action: string) {

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

  executeCommand(command: string) {
    this.http.post(`http://localhost:8765/command-registry/api/v1/commandregistry/execute/${command}`,
    {"csrUserId": "adawd"}).subscribe(res => {
      console.log(res);
    });
  }

}

