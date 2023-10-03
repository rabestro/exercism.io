BEGIN {FS = ""}
{
    for (; NF > 0; --NF) printf "%c", $(NF)
}
