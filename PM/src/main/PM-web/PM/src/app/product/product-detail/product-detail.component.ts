import { Component, OnInit } from '@angular/core';
import { IProduct } from '../model/product';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../service/product.service';
import {ProductTrackerError} from "../model/product-tracker-error";

@Component({
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  pageTitle: string = 'Product detail';
  product: IProduct;
  constructor(private _route: ActivatedRoute, private _productService: ProductService, private _router: Router) { }

  ngOnInit() {
    let id = this._route.snapshot.paramMap.get("id");
    this._productService.getProductById(id)
                    .subscribe((product: IProduct) => this.product = product,
                      (error: ProductTrackerError) => console.error(error));
  }

  goBack(): void{
      this._router.navigate(['/products']);
  }
}
