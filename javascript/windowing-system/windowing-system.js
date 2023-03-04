// @ts-check

export function Size(width = 80, height = 60) {
    this.width = width;
    this.height = height;
}

Size.prototype.resize = function (newWidth, newHeight) {
    this.width = newWidth;
    this.height = newHeight;
};

export function Position(x = 0, y = 0) {
    this.x = x;
    this.y = y;
}

Position.prototype.move = function (x, y) {
    this.x = x;
    this.y = y;
};

export class ProgramWindow {
    #screenSize;
    constructor() {
        this.#screenSize = new Size(800, 600);
        this._size = new Size();
        this._position = new Position();
    }

    get screenSize() {
        return this.#screenSize;
    }

    get size() {
        return this._size;
    }

    get position() {
        return this._position;
    }

    resize(size) {
        const maxWidth = this.screenSize.width - this._position.x;
        const maxHeight = this.screenSize.height - this._position.y;
        const width = Math.max(1, size.width);
        const height = Math.max(1, size.height);
        this._size = new Size(Math.min(width, maxWidth), Math.min(height, maxHeight));
    }

    move(position) {
        const maxX = this.screenSize.width - this._size.width;
        const maxY = this.screenSize.height - this._size.height;
        const x = Math.max(0, position.x);
        const y = Math.max(0, position.y);
        this._position = new Position(Math.min(x, maxX), Math.min(y, maxY));
    }
}

export function changeWindow(programWindow) {
    programWindow.resize(new Size(400, 300));
    programWindow.move(new Position(100, 150));
    return programWindow;
}
