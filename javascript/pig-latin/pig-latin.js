export const translate = phrase => {
  return phrase.replaceAll(
      /(?<consonants>(?!xr|yt)y?((qu)|[bcdfghjklmnpqrstvwxz])*)?(?<base>\w+)/g,
      '$<base>$<consonants>ay')
};
