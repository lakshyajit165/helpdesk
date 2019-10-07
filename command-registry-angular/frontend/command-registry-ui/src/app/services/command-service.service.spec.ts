<<<<<<< HEAD
import { TestBed } from '@angular/core/testing';

import { CommandServiceService } from './command-service.service';

describe('CommandServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));
=======
import { TestBed, inject } from '@angular/core/testing';

import { CommandServiceService } from './command-service.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpEvent, HttpEventType } from '@angular/common/http';
import { ResponseFormat } from '../model/ResponseFormat';


fdescribe('CommandServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule],
      providers: [CommandServiceService]
  }));
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69

  it('should be created', () => {
    const service: CommandServiceService = TestBed.get(CommandServiceService);
    expect(service).toBeTruthy();
  });
<<<<<<< HEAD
=======

  it(
    'should get commands',
    inject(
      [HttpTestingController, CommandServiceService],
      (
        httpMock: HttpTestingController,
        dataService: CommandServiceService
      ) => {
        // ...our test logic here
        const mockCommands = [
          {
            id: '5d8b485bdb1ccd91cc24bd7c',
            name: 'invoice',
            tags: null,
            desc: 'this command can be used to see invoice',
            last_updated_on: null,
            created_on: null,
            created_by: null,
            usage: null,
            status: 'active',
            parameters: {
                parameterName: null,
                required: null,
                default_value: null,
                description: null
            }
        },
        {
          id: '5d8b485bdb1ccd91cc24bd7d',
          name: 'add',
          tags: null,
          desc: 'this command can be used to see invoice',
          last_updated_on: null,
          created_on: null,
          created_by: null,
          usage: null,
          status: 'inactive',
          parameters: {
              parameterName: null,
              required: null,
              default_value: null,
              description: null
          }
        }
        ];

        // dataService.getcommands().subscribe((event: HttpEvent<ResponseFormat>) => {
        //   switch (event.type) {
        //     case HttpEventType.Response:
        //       expect(event.body).toEqual(mockCommands);
        //   }
        // });

        const mockReq = httpMock.expectOne(dataService.url);

        expect(mockReq.cancelled).toBeFalsy();
        expect(mockReq.request.responseType).toEqual('json');

        mockReq.flush(mockCommands);

        httpMock.verify();
        // ...our test logic here
      }
    )
  );
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
});
