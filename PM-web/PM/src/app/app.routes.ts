import {WelcomeComponent} from './home/welcome.component';
import {ProductDetailComponent} from './product/product-detail/product-detail.component';
import {ProductGuardService} from './product/guards/product-guard.service';
import {ProductListComponent} from './product/product-list/product-list.component';
import {Routes} from '@angular/router';

export const routes: Routes = [
    {path: 'welcome', component: WelcomeComponent},
    {path: '', redirectTo: 'welcome', pathMatch: 'full'},
    {path: '**', redirectTo: 'welcome', pathMatch: 'full' }
  ];