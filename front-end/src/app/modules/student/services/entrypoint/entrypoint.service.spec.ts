import { TestBed } from '@angular/core/testing';

import { EntrypointService } from './entrypoint.service';

describe('EntrypointService', () => {
  let service: EntrypointService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EntrypointService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
