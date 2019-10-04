import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';
import { ICommand } from '../model/CommandInterface';
import { ResponseFormat } from '../model/ResponseFormat';

@Injectable({
  providedIn: 'root'
})
export class CommandServiceService {

    public url = '/assets/data/commands.json';
    //  private url = 'http://spring-boot-command-registry:8082/api/v1/commandregistry/commands';
    //  private url = 'http://localhost:8082/api/v1/commandregistry/commands';

    constructor(private httpClient: HttpClient) { }

    getcommands(): Observable<ResponseFormat> {
      return this.httpClient.get<ResponseFormat>(this.url);
    }
    // errorHandler(error: HttpErrorResponse) {
    //   return Observable.throw(error.message || 'Server error');
    // }
    // addCommands(commandItems: ICommand): Observable<ResponseFormat> {
    //   console.log(
    //   'command items are', commandItems
    //   );
    //   return this.httpClient.post<ResponseFormat>(this.url, commandItems);
    // }

    // updateCommands(commandItems: ICommand): Observable<ResponseFormat> {
    // const url1 = this.url;
    // return this.httpClient.put<ResponseFormat>(url1, commandItems);
    // }
    addCommands(commandItems: ICommand) {
      console.log(
      'command items are', commandItems
      );
      return this.httpClient.post('http://localhost:8082/api/v1/commandregistry/commands', commandItems);
    }



     updateCommands(commandItems: ICommand): Observable<ICommand> {
     const url = this.url;
     return this.httpClient.patch<ICommand>(url, commandItems);
     }



}
