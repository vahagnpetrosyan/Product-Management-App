import { Injectable } from "@angular/core";
import {IProduct} from '../model/product';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { environment } from "../../../environments/environment";

@Injectable()
export class ProductService{
    private baseUrl: string = environment.apiRoot; 

    constructor(private _http: HttpClient){

    }
    
    public getProducts(): Observable<IProduct[]>{
        return this._http.get<IProduct[]>(this.baseUrl + '/api/products')
        .do(product => console.log('All:' + JSON.stringify(product)))
        .catch(this.handlerError);
    }

    public getProductById(id: string): Observable<IProduct>{
        return this._http.get<IProduct>(this.baseUrl + `/api/products/${id}`)
        .do(product => console.log(JSON.stringify(product)))
        .catch(err => this.handlerError(err));
    }

    public updateProduct(updatedProduct: IProduct): Observable<void>{
        return this._http.patch<void>(this.baseUrl + `/api/products/${updatedProduct.id}`, 
                    updatedProduct, {
                        headers: new HttpHeaders({
                            'Content-Type': 'application/json'
                        })
                    });
    }

    public addProduct(product: IProduct): Observable<IProduct> {
        return this._http.post<IProduct>(this.baseUrl + '/api/products', 
                        product, {
                            headers: new HttpHeaders({
                                'Content-Type': 'application/json'
                            })
                        });
    }

    public deleteProduct(id: number): Observable<void>{
        return this._http.delete<void>(this.baseUrl + `/api/products/${id}`);
    }

    private handlerError(err: HttpErrorResponse){
        console.log(err.message);
        return Observable.throw(err);
    }
}