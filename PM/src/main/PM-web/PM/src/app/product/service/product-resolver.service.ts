import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {IProduct} from '../model/product';
import {ProductTrackerError} from '../model/product-tracker-error';
import {ProductService} from './product.service';
import {Observable} from 'rxjs';


@Injectable()
export class ProductResolverService implements Resolve<IProduct[] | ProductTrackerError> {

  constructor(private productService: ProductService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IProduct[] | ProductTrackerError> {
         return this.productService.getProducts();
  }
}
