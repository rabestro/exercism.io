// Given a DNA strand, return its RNA complement (per RNA transcription).

export const toRna = (dna) => {
    const transcription = {G: 'C', C: 'G', T: 'A', A: 'U'};
    return dna
        .split('')
        .map(nucleotide => transcription[nucleotide])
        .join('');
};
