BEGIN {
    FS=""
}
{
    while (NF > 0) {
        printf $(NF--)
    }
    print ""
}
