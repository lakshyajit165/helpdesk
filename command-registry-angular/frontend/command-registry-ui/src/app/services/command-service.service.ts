import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';
import { ICommand } from '../model/CommandInterface';

@Injectable({
  providedIn: 'root'
})
export class CommandServiceService {

    // private url = '/assets/data/commands.json';
    //  private url = 'http://spring-boot-command-registry:8082/api/v1/commandregistry/commands';
     private url = 'http://localhost:8765/api/v1/commandregistry/commands';

    constructor(private httpClient: HttpClient) { }

    getcommands(): Observable<any> {
       return this.httpClient.get(this.url);
    }
    // errorHandler(error: HttpErrorResponse) {
    //   return Observable.throw(error.message || 'Server error');
    // }
    addCommands(commandItems: ICommand) {
      console.log(
      'command items are', commandItems
      );
      return this.httpClient.post(this.url, commandItems);
    }
}
