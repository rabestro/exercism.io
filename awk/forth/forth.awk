BEGIN {
    #    RS = " "
    Number = @/-?[[:digit:]]+/
    BiOperator = @/[-+*]|[/]|swap|over/
}
#{
#    print "Record["$0"]"
#}
BEGINFILE {
    delete Stack
    delete Macro
    Size = 0
}
function die(message) {print message > "/dev/stderr"; exit 1}

$1 == ":" {
    if ($NF != ";") die("macro not terminated with semicolon")
    if (NF < 4) die("empty macro definition")
    if ($2 ~ /-?[[:digit:]]+/) die("illegal operation")
    name = $2
    $1 = $2 = $NF = ""
    Macro[name] = $0
    next
}
{
    for (i = 1; i <= NF; ++i) {
        if ($i ~ Number) push($i)
        else if ($i in Macro) {
            $i = Macro[$i]
            $0 = $0
            --i
        } else if ($i ~ BiOperator) {
            required(2)
            b = pop()
            a = pop()
            switch ($i) {
                case "+": push(a + b); break
                case "-": push(a - b); break
                case "*": push(a * b); break
                case "/":
                    if (!b) die("divide by zero")
                    push(int(a / b)); break
                case "swap": push(b); push(a); break
                case "over": push(a); push(b); push(a); break
            }
        } else if ($i ~ /dup|drop/) {
            required(1)
            a = pop()
            if ($i ~ /dup/) {
                push(a); push(a);
            }
        }
    }
}

END {
    NF = Size
    while (Size) {
        $Size = Stack[Size]
        --Size
    }
    print
}
function required(n) {
    if (!Size) print "empty stack"
    else if (n > 1 && Size == 1) print "only one value on the stack"
    else return
    exit 1
}
function push(element) {
    Stack[++Size] = element
}
function pop() {
    return Stack[Size--]
}
