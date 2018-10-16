import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { IProduct } from '../model/product';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { ToastrService } from 'ngx-toastr';
import {ProductTrackerError} from '../model/product-tracker-error';

@Component({
  selector: 'pm-product-insert',
  templateUrl: './product-insert.component.html',
  styleUrls: ['./product-insert.component.css']
})
export class ProductInsertComponent implements OnInit {

  public product: IProduct;

  @Output()
  public productSubmitted: EventEmitter<IProduct> = new EventEmitter();

  @Output()
  public expanded: EventEmitter<boolean> = new EventEmitter();

  constructor(private _router: Router,
              private _productService: ProductService,
              private _toastrService: ToastrService) {
  }

  ngOnInit() {
    this.product = {
      id: null,
      productName: null,
      productCode: null,
      description: null,
      releaseDate: null,
      price: null,
      starRating: null,
      imageUrl: null
    };
  }

  onSubmit() {
      this._productService.addProduct(this.product).subscribe((data: IProduct) => {
        this._toastrService.success('Successfully added!', 'Add');
        this.productSubmitted.emit(data);
        this.expanded.emit(false);
      }, (error: ProductTrackerError) => {
        console.error(error);
      });
  }

}
