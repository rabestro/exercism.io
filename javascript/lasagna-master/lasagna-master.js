/// <reference path="./global.d.ts" />
// @ts-check

export function cookingStatus(minutes) {
    if (minutes === undefined) return 'You forgot to set the timer.'
    if (minutes) return 'Not done, please wait.'
    return 'Lasagna is done.'
}

export function preparationTime(layers, minutes = 2) {
    return layers.length * minutes;
}

export function quantities(layers) {
    return {
        noodles: layers.filter(x => x === 'noodles').length * 50,
        sauce: layers.filter(x => x === 'sauce').length * 0.2,
    }
}

export function addSecretIngredient(friendsList, myList) {
    myList.push(friendsList.at(-1));
}

export function scaleRecipe(recipe, persons) {
    const result = {};
    for (const item in recipe)
        result[item] = recipe[item] * persons / 2;
    return result;
}
