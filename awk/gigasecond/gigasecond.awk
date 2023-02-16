BEGIN {
    GigaSecond = 1e9
}
{
    gsub(/[-T:]/, " ")
}
{
    time = mktime($0" 01 00 00") + GigaSecond
    print strftime("%FT%T", time)
}
