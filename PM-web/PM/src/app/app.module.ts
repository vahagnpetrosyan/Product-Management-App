import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './home/welcome.component';
import {routes} from './app.routes';
import { ProductModule } from './product/product.module' 
@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule.forRoot(routes, {useHash: true}),
    ProductModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
