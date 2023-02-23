export const isIsogram = word => {
    return !/([a-z]).*?\1/i.test(word);
};
