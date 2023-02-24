export const isPangram = phrase =>
  !'abcdefghijklmnopqrstuvwxyz'
      .replaceAll(new RegExp(`[${phrase}]`, 'gi'), '');
