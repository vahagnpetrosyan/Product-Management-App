import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from "@angular/common/http";
import {HttpCacheService} from "../http-cache.service";
import {Observable} from "rxjs/Observable";
import {tap} from "rxjs/operators";
import {of} from "rxjs/observable/of";

@Injectable()
export class CacheInterceptor implements HttpInterceptor {
    constructor(private cacheService: HttpCacheService) {}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if(req.method !== 'GET') {
          console.log(`Invalidating chache: ${req.method} ${req.url}`);
          this.cacheService.invalidateCache();
          return next.handle(req);
        }

        const cachedResponse: HttpResponse<any> = this.cacheService.get(req.url);

        if(cachedResponse){
          console.log(`Returning a cached response: ${cachedResponse.url}`);
          console.log(cachedResponse);
          return of(cachedResponse);
        }

        return next.handle(req).pipe(
          tap(event => {
            if(event instanceof HttpResponse) {
              console.log(`Adding item to cache: ${req.url}`);
              this.cacheService.put(req.url, event);
            }
          })
        )
    }
}
