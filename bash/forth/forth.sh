#!/usr/bin/env bash

# Declare an indexed array as the stack
declare -a stack

# Initialize the top index of the stack
top=-1

# Function to push an element onto the stack
push() {
  ((top++))
  stack[$top]="$1"
}

# Function to pop an element from the stack
pop() {
  if [ $top -ge 0 ]; then
    local popped_value="${stack[$top]}"
    echo "$popped_value"
    ((top--))
  else
    echo "Stack is empty."
  fi
}

# Function to display the elements in the stack

display() {
  if [ $top -ge 0 ]; then
    echo "Stack elements are:"
    for i in "${stack[@]}"; do
      echo "$i"
    done
  else
    echo "Stack is empty."
  fi
}
