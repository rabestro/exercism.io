export const age = (planet, seconds) => {
    const orbitalPeriods = {
        earth: 1,
        mercury: 0.2408467,
        venus: 0.61519726,
        mars: 1.8808158,
        jupiter: 11.862615,
        saturn: 29.447498,
        uranus: 84.016846,
        neptune: 164.79132
    }
    const ageOnEarth = seconds / 3.15576e7;
    return round(ageOnEarth * orbitalPeriods[planet]);
};

function round(number) {
    return Math.round(number * 100) / 100;
}