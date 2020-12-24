export class ResistorColor {

    private readonly colors: string[];

    constructor(colors: string[]) {
        if (colors.length < 2) {
            throw "At least two colors need to be present";
        }
        this.colors = colors;
    }

    value = (): number => {
        const colorsMap = ['black', 'brown', 'red', 'orange', 'yellow', 'green', 'blue', 'violet', 'grey', 'white'];
        return colorsMap.indexOf(this.colors[0]) * 10 + colorsMap.indexOf(this.colors[1])
    }
}
