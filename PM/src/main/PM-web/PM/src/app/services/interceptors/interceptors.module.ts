import {NgModule} from "@angular/core";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {AddHeaderInterceptor} from "./add-header.interceptor";
import {LogResponseInterceptor} from "./log-response.interceptor";

@NgModule({
   providers: [
     {provide: HTTP_INTERCEPTORS, useClass: AddHeaderInterceptor, multi: true},
     {provide: HTTP_INTERCEPTORS, useClass: LogResponseInterceptor, multi: true},
   ]
})
export class InterceptorsModule{}
