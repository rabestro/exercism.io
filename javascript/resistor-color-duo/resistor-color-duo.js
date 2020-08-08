export const decodedValue = (resColors) => {
  const COLORS = ["black","brown","red","orange","yellow","green","blue","violet","grey","white"];
  return COLORS.indexOf(resColors[0]) * 10 + COLORS.indexOf(resColors[1])
};

