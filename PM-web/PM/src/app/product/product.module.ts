import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import {productRoutes} from './product.routes';
import { ProductService } from './service/product.service';
import { ProductGuardService } from './guards/product-guard.service';
import { SharedModule } from './../shared/shared.module';
import { ProductUpsertComponent } from './product-upsert/product-upsert.component';
import { MatDesignModule } from '../design/mat-design.module';
import { ToastrModule } from 'ngx-toastr';
import { ProductInsertComponent } from './product-insert/product-insert.component';
import { ProductDeleteDialogComponent } from './product-delete/product-delete-dialog.component';

@NgModule({
  imports: [
    RouterModule.forChild(productRoutes),
    SharedModule,
    MatDesignModule,
    ToastrModule.forRoot()
  ],
  declarations: [
    ProductListComponent,
    ProductDetailComponent,
    ProductUpsertComponent,
    ProductInsertComponent,
    ProductDeleteDialogComponent,
  ],
  entryComponents: [
    ProductDeleteDialogComponent
  ],
  providers: [
    ProductService,
    ProductGuardService
  ]

})
export class ProductModule { }
