import { TestBed, inject } from '@angular/core/testing';

import { PopularPurchaseService } from './popular-purchase.service';

describe('PopularPurchaseService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PopularPurchaseService]
    });
  });

  it('should be created', inject([PopularPurchaseService], (service: PopularPurchaseService) => {
    expect(service).toBeTruthy();
  }));
});
