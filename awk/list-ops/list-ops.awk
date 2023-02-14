@namespace "listops"

# Append to a list all the elements of another list.
# Or append to a list a single new element
function append(list, item_or_list,   size,i) {
    size = length(list)
    if (awk::typeof(item_or_list) == "array")
        for (i in item_or_list) list[++size] = item_or_list[i]
    else list[++size] = item_or_list
}

# Concatenate is flattening a list of lists one level
function concat(list, result,   a,b,size) {
    for (a in list) for (b in list[a]) result[++size] = list[a][b]
}

# Only the list elements that pass the given function.
function filter(list, funcname, result,   i,size) {
    for (i in list) if (@funcname(list[i])) result[++size] = list[i]
}

# Transform the list elements, using the given function, into a new list.
function map(list, funcname, result) {
    print "Implement me" > "/dev/stderr"
    exit 1
}

# Left-fold the list using the function and the initial value.
function foldl(list, funcname, initial) {
    print "Implement me" > "/dev/stderr"
    exit 1
}

# Right-fold the list using the function and the initial value.
function foldr (list, funcname, initial) {
    print "Implement me" > "/dev/stderr"
    exit 1
}

# the list reversed
function reverse (list, result) {
    print "Implement me" > "/dev/stderr"
    exit 1
}
