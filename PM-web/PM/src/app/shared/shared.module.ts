import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConvertToSpacePipe } from './pipes/convert-to-space.pipe';
import { StarComponent } from './star/star.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    ConvertToSpacePipe,
    StarComponent
  ],
  exports: [
    ConvertToSpacePipe,
    StarComponent,
    FormsModule,
    CommonModule
  ]
})
export class SharedModule { }
