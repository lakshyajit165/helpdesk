import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';
import { ICommand } from '../model/CommandInterface';
<<<<<<< HEAD
=======
import { ResponseFormat } from '../model/ResponseFormat';
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69

@Injectable({
  providedIn: 'root'
})
export class CommandServiceService {

<<<<<<< HEAD
    // private url = '/assets/data/commands.json';
    //  private url = 'http://spring-boot-command-registry:8082/api/v1/commandregistry/commands';
     private url = 'http://localhost:8765/api/v1/commandregistry/commands';

    constructor(private httpClient: HttpClient) { }

    getcommands(): Observable<any> {
       return this.httpClient.get(this.url);
=======
    public url = '/assets/data/commands.json';
    //  private url = 'http://spring-boot-command-registry:8082/api/v1/commandregistry/commands';
    //  private url = 'http://localhost:8082/api/v1/commandregistry/commands';

    constructor(private httpClient: HttpClient) { }

    getcommands(): Observable<ResponseFormat> {
      return this.httpClient.get<ResponseFormat>(this.url);
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
    }
    // errorHandler(error: HttpErrorResponse) {
    //   return Observable.throw(error.message || 'Server error');
    // }
<<<<<<< HEAD
=======
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
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
    addCommands(commandItems: ICommand) {
      console.log(
      'command items are', commandItems
      );
<<<<<<< HEAD
      return this.httpClient.post(this.url, commandItems);
    }
=======
      return this.httpClient.post('http://localhost:8082/api/v1/commandregistry/commands', commandItems);
    }



     updateCommands(commandItems: ICommand): Observable<ICommand> {
     const url = this.url;
     return this.httpClient.patch<ICommand>(url, commandItems);
     }



>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
}
