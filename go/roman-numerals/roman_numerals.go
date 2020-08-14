package romannumerals

import "errors"

func ToRomanNumeral(number int) (string, error) {
	if number < 1 || number > 3000 {
		return "", errors.New("number has to be in range [1..3000]")
	}
	return []string{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}[number%10], nil
}
