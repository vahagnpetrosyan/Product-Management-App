import { Injectable } from '@angular/core';
import {IProduct} from '../model/product';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { environment } from '../../../environments/environment';
import {ProductTrackerError} from '../model/product-tracker-error';
import {ErrorObservable} from 'rxjs/observable/ErrorObservable';

@Injectable()
export class ProductService {
    private baseUrl: string = environment.apiRoot;

    constructor(private _http: HttpClient){

    }

    public getProducts(): Observable<IProduct[] | ProductTrackerError> {
        return this._http.get<IProduct[]>(this.baseUrl + '/api/products')
        .do(product => console.log('All:' + JSON.stringify(product)))
        .catch(this.handlerError);
    }

    public getProductById(id: string): Observable<IProduct | ProductTrackerError> {
        return this._http.get<IProduct>(this.baseUrl + `/api/products/${id}`)
        .do(product => console.log(JSON.stringify(product)))
        .catch(this.handlerError);
    }

    public updateProduct(updatedProduct: IProduct): Observable<void | ProductTrackerError> {
        return this._http.patch<void>(this.baseUrl + `/api/products/${updatedProduct.id}`,
                    updatedProduct, {
                        headers: new HttpHeaders({
                            'Content-Type': 'application/json'
                        })
                    }).catch(this.handlerError);
    }

    public addProduct(product: IProduct): Observable<IProduct | ProductTrackerError> {
        return this._http.post<IProduct>(this.baseUrl + '/api/products',
                        product, {
                            headers: new HttpHeaders({
                                'Content-Type': 'application/json'
                            })
                        }).catch(this.handlerError);
    }

    public deleteProduct(id: number): Observable<void | ProductTrackerError> {
        return this._http.delete<void>(this.baseUrl + `/api/products/${id}`)
          .catch(this.handlerError);
    }

    private handlerError(error: HttpErrorResponse): Observable<ProductTrackerError> {
        return ErrorObservable.create(new ProductTrackerError(error.status, error.message));
    }
}
