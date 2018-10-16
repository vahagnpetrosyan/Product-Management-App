import { Component, OnInit } from '@angular/core';
import { IProduct } from '../model/product';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';
import { ToastrService } from 'ngx-toastr';
import {ProductTrackerError} from '../model/product-tracker-error';

@Component({
  selector: 'pm-product-upsert',
  templateUrl: './product-upsert.component.html',
  styleUrls: ['./product-upsert.component.css']
})
export class ProductUpsertComponent implements OnInit {

  public product: IProduct;
  public isReady: boolean;

  constructor(private _route: ActivatedRoute,
    private _productService: ProductService,
    private _router: Router, private _toastrService: ToastrService) { }

  ngOnInit() {
    let id: string;
    this._route.paramMap.subscribe(params => {
      id = params.get('id');
      this._productService.getProductById(id)
      .subscribe((product: IProduct) => {
        this.product = product;
        this.isReady = true;
      }, (error: ProductTrackerError) => {
        console.error(error);
      });

    });
  }

  public onSubmit() {
    this._productService.updateProduct(this.product).subscribe(() => {
       this._toastrService.success('Product is updated!', 'Update');
       this._router.navigate(['/products']);
    }, (error: ProductTrackerError) => console.error(error));
  }

}
