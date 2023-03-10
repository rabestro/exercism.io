if (.strand1 | length) != (.strand2 | length)
then
    "strands must be of equal length" | halt_error
else
    0
end
