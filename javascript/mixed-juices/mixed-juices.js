// @ts-check

/**
 * Determines how long it takes to prepare a certain juice.
 *
 * @param {string} name
 * @returns {number} time in minutes
 */
export function timeToMixJuice(name) {
    switch (name) {
        case 'Pure Strawberry Joy':
            return 0.5;
        case 'Energizer':
        case 'Green Garden':
            return 1.5;
        case 'Tropical Island':
            return 3;
        case 'All or Nothing':
            return 5;
        default:
            return 2.5;
    }
}

const LIME_SIZE = {small: 6, medium: 8, large: 10}

/**
 * Calculates the number of limes that need to be cut
 * to reach a certain supply.
 *
 * @param {number} wedgesNeeded
 * @param {string[]} limes
 * @returns {number} number of limes cut
 */
export function limesToCut(wedgesNeeded, limes) {
    let i = 0;
    while (wedgesNeeded > 0 && i < limes.length) {
        wedgesNeeded -= LIME_SIZE[limes[i++]] ?? LIME_SIZE.medium;
    }
    return i;
}

/**
 * Determines which juices still need to be prepared after the end of the shift.
 *
 * @param {number} timeLeft
 * @param {string[]} orders
 * @returns {string[]} remaining orders after the time is up
 */
export function remainingOrders(timeLeft, orders) {
    while (timeLeft > 0 && orders.length) {
        timeLeft -= timeToMixJuice(orders.shift());
    }
    return orders;
}
