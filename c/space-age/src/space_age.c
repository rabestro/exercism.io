#include "space_age.h"

float convert_planet_age(planet_t planet, int64_t input) {
    switch (planet) {
        case EARTH:
            return input / 31557600.0;
        case MERCURY:
            return convert_planet_age(EARTH, input) / 0.2408467;
        case VENUS:
            return convert_planet_age(EARTH, input) / 0.61519726;
        case MARS:
            return convert_planet_age(EARTH, input) / 0.2408467;
        case JUPITER:
            return convert_planet_age(EARTH, input) / 0.2408467;
        case SATURN:
            return convert_planet_age(EARTH, input) / 0.2408467;
        case URANUS:
            return convert_planet_age(EARTH, input) / 0.2408467;
        case NEPTUNE:
            return convert_planet_age(EARTH, input) / 0.2408467;
        default:
            return 0.0;
    }
}
