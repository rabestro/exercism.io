class Raindrops {

    def convert(number) {
        def output = ''

        if (number % 3 == 0) {
            output += 'Pling'
        }
        if (number % 5 == 0) {
            output += 'Plang'
        }
        if (number % 7 == 0) {
            output += 'Plong'
        }
        if (output.isEmpty()) {
            output += number
        }
        return output
    }

}
