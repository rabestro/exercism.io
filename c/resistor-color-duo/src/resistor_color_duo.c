#include "resistor_color_duo.h"

int color_code(resistor_band_t *color) {
    return (int) *color * 10 + color[1];
}
