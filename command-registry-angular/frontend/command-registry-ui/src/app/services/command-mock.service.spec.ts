import { TestBed } from '@angular/core/testing';

import { CommandMockService } from './command-mock.service';

describe('CommandMockService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CommandMockService = TestBed.get(CommandMockService);
    expect(service).toBeTruthy();
  });
});
