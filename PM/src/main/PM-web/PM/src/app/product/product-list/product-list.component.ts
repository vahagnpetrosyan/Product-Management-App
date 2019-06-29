import {Component, OnInit, OnDestroy} from '@angular/core';
import {IProduct} from '../model/product';
import { ProductService } from '../service/product.service';
import {Router, NavigationEnd, ActivatedRoute} from '@angular/router';
import {MatDialog, MatExpansionPanel} from '@angular/material';
import { ProductDeleteDialogComponent } from '../product-delete/product-delete-dialog.component';
import {ProductTrackerError} from '../model/product-tracker-error';
@Component({
    templateUrl: './product-list.component.html',
    styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit, OnDestroy{
  productList: string = 'Product List';

  imageWindth: number = 50;
  imageMargin: number = 2;
  showImage: boolean = false;

  private _httpErrorMessage: string;
  private _navigationSubscription: any;

  private _filterParam: string;

  constructor(private _productService: ProductService,
              private _router: Router,
              public dialog: MatDialog,
              private route: ActivatedRoute ) {}

  public get filterParam(): string {
    return this._filterParam;
  }

  public set filterParam(value: string) {
      this._filterParam = value;
      this.filteredProducts = value ? this.filterByParam(value) : this.products;
  }

  private _filteredProducts: IProduct[] = [];
  products: IProduct[];

  public get filteredProducts(): IProduct[] {
    return this._filteredProducts;
  }
  public set filteredProducts(value: IProduct[]) {
    this._filteredProducts = value;
  }

  ngOnInit(): void {
    this.init();
 }

 init() {
   const data: IProduct[] | ProductTrackerError = this.route.snapshot.data['resolvedData'];
   if (data instanceof ProductTrackerError) {
     throw new Error('Can not get products');
   } else {
     this.products = data;
     this._filteredProducts = this.products;
   }
 }

  toggleShowImage(): void{
      this.showImage = !this.showImage;
  }

  toggleExpansion(matExpansionPanel: MatExpansionPanel, event: boolean){
     event && matExpansionPanel.close();
  }

  filterByParam(param: string): IProduct[] {
      return this.products.filter((product: IProduct) =>
            product.productName.toLocaleLowerCase().indexOf(param.toLocaleLowerCase()) !== -1);
  }

  onRankClicked(eventValue: string): void {
      this.productList = this.productList + eventValue;
  }

  onProductSubmitted(event: IProduct) {
    this.filteredProducts.push(event);
  }

  onDelete(productId: number){
      const dialogRef = this.dialog.open(ProductDeleteDialogComponent, {
          height: '200px',
          width: '350px'
      });

      dialogRef.afterClosed().subscribe(result => {
          if (result) {
             this._productService.deleteProduct(productId).subscribe(() => {
                this._filteredProducts = this.filteredProducts.filter(item => item.id !== productId);
                this.products = this.filteredProducts;
             }, (error: ProductTrackerError) => console.error(error));
          }
      });
  }

  ngOnDestroy() {
      if (this._navigationSubscription){
        this._navigationSubscription.unsubscribe();
      }
  }
}
