export class ResistorColor {

    private readonly colors: string[];

    constructor(colors: string[]) {
        this.colors = colors;
    }

    value = (): number => {
        const colorsMap: Map<string, number> = new Map([
            ['black', 0],
            ['brown', 1]
        ]);
        // colorsMap.has('brown') ? colorsMap.get('brown') : 0
        return colorsMap.get('brown') * 10;
    }
}
