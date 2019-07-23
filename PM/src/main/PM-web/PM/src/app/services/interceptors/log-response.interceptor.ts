import {Injectable} from "@angular/core";
import {
  HttpErrorResponse,
  HttpEvent,
  HttpEventType,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {ToastrService} from "ngx-toastr";

@Injectable()
export class LogResponseInterceptor implements HttpInterceptor{

  constructor(private _toastrService: ToastrService){}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log(`LogResponseInterceptor - ${req.url}`);

    return next.handle(req).do(() => {}, (response) => {
      if(response instanceof HttpErrorResponse){
        this._toastrService.error("Bad Action");
      }
    })
  }

}
