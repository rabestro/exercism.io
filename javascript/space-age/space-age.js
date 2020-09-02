export const age = (planet, seconds) => {
    const onEarth = seconds / 31557600;
    switch (planet) {
        case 'earth':
            return round(onEarth);
        case 'mercury':
            return round(onEarth / 0.2408467);
        case 'venus':
            return round(onEarth / 0.61519726);
        case 'mars':
            return round(onEarth / 1.8808158);
        case 'jupiter':
            return round(onEarth / 11.862615);
        case 'saturn':
            return round(onEarth / 29.447498);
        case 'uranus':
            return round(onEarth / 84.016846);
        case 'neptune':
            return round(onEarth / 164.79132);
    }
    return 0;
};

function round(number) {
    return Math.round(number * 100) / 100;
}