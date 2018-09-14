import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductUpsertComponent } from './product-upsert.component';

describe('ProductUpsertComponent', () => {
  let component: ProductUpsertComponent;
  let fixture: ComponentFixture<ProductUpsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductUpsertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductUpsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
