#include "space_age.h"

float convert_planet_age(planet_t planet, int64_t input) {
    switch (planet) {
        case EARTH:
            return input / 31557600.0;
        case MERCURY:
            return convert_planet_age(EARTH, input) / 0.2408467;
        case VENUS:
        case MARS:
        case JUPITER:
        case SATURN:
        case URANUS:
        case NEPTUNE:
        default:
            return 0.0;
    }
}
