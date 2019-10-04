import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CommandMockService {
   private url = '/assets/data/commands.json';

  constructor(private httpClient: HttpClient) { }
  getcommands(): Observable<any> {
    return this.httpClient.get(this.url);
 }
}
