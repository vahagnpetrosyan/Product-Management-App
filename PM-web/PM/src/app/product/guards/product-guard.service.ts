import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { Location } from '@angular/common';

@Injectable()
export class ProductGuardService implements CanActivate {

  constructor(private _router: Router) { }

  canActivate(route: ActivatedRouteSnapshot): boolean{
    let id = +route.url[1].path;
    if(isNaN(id) || id < 1) {
      this._router.navigate['/products'];
      alert("Invalid product id");
      return false;
    }
    return true;
  }

}
