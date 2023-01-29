BEGIN {

}
{
    print pigify($0)
}

function pigify(word) {
    return word"ay"
}
