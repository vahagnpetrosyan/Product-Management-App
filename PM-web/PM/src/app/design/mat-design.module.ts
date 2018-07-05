import { NgModule } from "@angular/core";
import {MatButtonModule, MatCheckboxModule, MatListModule, MatExpansionModule, MatDialogModule} 
from '@angular/material';

@NgModule({
    imports: [
        MatButtonModule,
        MatCheckboxModule,
        MatListModule,
        MatExpansionModule,
        MatDialogModule
    ],

    exports: [
        MatButtonModule,
        MatCheckboxModule,
        MatListModule,
        MatExpansionModule,
        MatDialogModule
    ]
})

export class MatDesignModule{}