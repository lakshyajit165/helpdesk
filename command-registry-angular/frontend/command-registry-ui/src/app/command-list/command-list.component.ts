

import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute,  NavigationExtras } from '@angular/router';

import { ICommand } from '../model/CommandInterface';
import { CommandServiceService } from '../services/command-service.service';

@Component({

  selector: 'app-command-list',
  templateUrl: './command-list.component.html',
  styleUrls: ['./command-list.component.css']
})
export class CommandListComponent implements OnInit {
  p = 1;

  public commands: ICommand[];

  public searchTerm: string;
  public ICommand = [];





  constructor(public commandService: CommandServiceService, private router: Router, private route: ActivatedRoute) { }


  ngOnInit() {
    this.commandService.getcommands()
        .subscribe(data => {
          this.commands = data.result;
          console.log(data.result);
        });

  }
  onClickList(command: {}) {
   // console.log('hello');


    console.log(this.commands);

    const navigationExtras: NavigationExtras = {
      state: {

        cmd : command
      }


    };
    this.router.navigate(['form'], navigationExtras);
  }

  //  onClickList() {
  //    this.router.navigateByUrl('/form/id');
  //  }


}
