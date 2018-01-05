import { TestBed, inject } from '@angular/core/testing';

import { PurchaseService } from './purchase.service';

describe('Purchase.ServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PurchaseService]
    });
  });

  it('should be created', inject([PurchaseService], (service: PurchaseService) => {
    expect(service).toBeTruthy();
  }));
});
