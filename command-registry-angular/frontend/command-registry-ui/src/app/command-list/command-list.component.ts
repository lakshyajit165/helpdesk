import { Component, OnInit } from '@angular/core';
import { CommandServiceService } from '../services/command-service.service';
@Component({

  selector: 'app-command-list',
  templateUrl: './command-list.component.html',
  styleUrls: ['./command-list.component.css']
})
export class CommandListComponent implements OnInit {
  p = 1;
  public commands = [];
  public searchTerm: string;

  constructor(private commandService: CommandServiceService) { }

  ngOnInit() {
    this.commandService.getcommands()
        .subscribe(data => this.commands = data.result);
  }

}
