
export class IProduct {
    constructor(
        public id: number,
        public productName: string,
        public productCode: string,
        public releaseDate: string,
        public description: string,
        public price: number,
        public starRating: number,
        public imageUrl: string
    ) {}
}
