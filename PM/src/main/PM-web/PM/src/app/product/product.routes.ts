import {ProductListComponent} from './/product-list/product-list.component';
import {ProductGuardService} from './guards/product-guard.service';
import {ProductDetailComponent} from './product-detail/product-detail.component';
import {Routes} from '@angular/router';
import { ProductUpsertComponent } from './product-upsert/product-upsert.component';
import {ProductResolverService} from './service/product-resolver.service';

export const productRoutes: Routes = [
    { path: 'products', component: ProductListComponent, resolve: {resolvedData: ProductResolverService}},
    { path: 'products/:id',
    canActivate: [ ProductGuardService ],
    component: ProductDetailComponent },
    { path: 'edit/:id', canActivate: [ ProductGuardService ], component: ProductUpsertComponent }
];
