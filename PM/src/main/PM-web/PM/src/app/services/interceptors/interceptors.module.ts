import {NgModule} from "@angular/core";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {AddHeaderInterceptor} from "./add-header.interceptor";
import {LogResponseInterceptor} from "./log-response.interceptor";
import {CacheInterceptor} from "./cache.interceptor";
import {HttpCacheService} from "../http-cache.service";

@NgModule({
   providers: [
     HttpCacheService,
     {provide: HTTP_INTERCEPTORS, useClass: AddHeaderInterceptor, multi: true},
     {provide: HTTP_INTERCEPTORS, useClass: LogResponseInterceptor, multi: true},
     {provide: HTTP_INTERCEPTORS, useClass: CacheInterceptor, multi: true},
   ]
})
export class InterceptorsModule{}
