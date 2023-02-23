export const hey = (message) => {
    if (/^[^a-z]*[A-Z][^a-z]*\? *$/.test(message)) return "Calm down, I know what I'm doing!"
    if (/^[^a-z]*[A-Z][^a-z]*$/.test(message)) return 'Whoa, chill out!'
    if (/\?\s*$/.test(message)) return "Sure."
    if (/^\s*$/.test(message)) return "Fine. Be that way!"
    return "Whatever."
};
