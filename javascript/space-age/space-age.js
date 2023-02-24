const EARTH_YEAR_SECOND = 3.15576e7;

const ORBITAL_PERIODS = {
    earth: 1,
    mercury: 0.2408467,
    venus: 0.61519726,
    mars: 1.8808158,
    jupiter: 11.862615,
    saturn: 29.447498,
    uranus: 84.016846,
    neptune: 164.79132
}
const FORMAT = new Intl.NumberFormat('en-IN', { maximumSignificantDigits: 2 });

export const age = (planet, seconds) => {
    const ageOnEarth = seconds / EARTH_YEAR_SECOND;
    const ageOnPlanet = ageOnEarth / ORBITAL_PERIODS[planet];
    return FORMAT.format(ageOnPlanet);
};

function round(number) {
    return Math.round(number * 100) / 100;
}
