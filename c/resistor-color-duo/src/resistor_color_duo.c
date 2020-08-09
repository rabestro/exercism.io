#include "resistor_color_duo.h"

int color_code(resistor_band_t *color) {
    return (int) *color * 10 + color[1];
}


const resistor_band_t* colors() {
    static resistor_band_t result[] = {
            BLACK, BROWN, RED, ORANGE, YELLOW,
            GREEN, BLUE, VIOLET, GREY, WHITE
    };

    return result;
}