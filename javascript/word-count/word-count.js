export const countWords = sentence =>
    sentence.toLowerCase()
        .match(/\w+('\w+)?/g)
        .reduce((counts, word) => ({...counts, [word]: ~~counts[word] + 1}), {});
