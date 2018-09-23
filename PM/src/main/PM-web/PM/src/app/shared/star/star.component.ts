import {Component, Input, OnChanges, Output, EventEmitter} from '@angular/core';
@Component({
    selector: 'pm-star',
    templateUrl: './star.component.html',
    styleUrls: ['./star.component.css']
})
export class StarComponent implements OnChanges{
@Input()   
public rating: number;
    
public starWidth: number;

@Output() rankClickedEvent: EventEmitter<string> = 
                new EventEmitter<string>();

    ngOnChanges(): void{
        this.starWidth = this.rating * 86/5;
    }

    onClick(): void{
        this.rankClickedEvent.emit(` :this ${this.rating} is clicked`);
    }
}