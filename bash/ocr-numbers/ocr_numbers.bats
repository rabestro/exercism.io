#!/usr/bin/env bats
load bats-extra

# local version: 1.2.0.0


@test "No input" {
    #[[ $BATS_RUN_SKIPPED == "true" ]] || skip
    run bash ocr_numbers.sh
    assert_success
    assert_output ""
}

@test "Recognizes 0" {
    run bash ocr_numbers.sh << INPUT
 _ 
| |
|_|
   
INPUT
    assert_success
    assert_output "0"
}

@test "Recognizes 1" {
    run bash ocr_numbers.sh << INPUT
   
  |
  |
   
INPUT
    assert_success
    assert_output "1"
}

@test "Unreadable but correctly sized inputs return ?" {
    run bash ocr_numbers.sh << INPUT
   
  _
  |
   
INPUT
    assert_success
    assert_output "?"
}

@test "Input with a number of lines that is not a multiple of four raises an error" {
    run bash ocr_numbers.sh << INPUT
 _ 
| |
   
INPUT
    assert_failure
    assert_output "Number of input lines is not a multiple of four"
}

@test "Input with a number of columns that is not a multiple of three raises an error" {
    run bash ocr_numbers.sh << INPUT
    
   |
   |
    
INPUT
    assert_failure
    assert_output "Number of input columns is not a multiple of three"
}

@test "Recognizes 110101100" {
    run bash ocr_numbers.sh << INPUT
       _     _        _  _ 
  |  || |  || |  |  || || |
  |  ||_|  ||_|  |  ||_||_|
                           
INPUT
    assert_success
    assert_output "110101100"
}

@test "Garbled numbers in a string are replaced with ?" {
    run bash ocr_numbers.sh << INPUT
       _     _           _ 
  |  || |  || |     || || |
  |  | _|  ||_|  |  ||_||_|
                           
INPUT
    assert_success
    assert_output "11?10?1?0"
}

@test "Recognizes 2" {
    run bash ocr_numbers.sh << INPUT
 _ 
 _|
|_ 
   
INPUT
    assert_success
    assert_output "2"
}

@test "Recognizes 3" {
    run bash ocr_numbers.sh << INPUT
 _ 
 _|
 _|
   
INPUT
    assert_success
    assert_output "3"
}

@test "Recognizes 4" {
    run bash ocr_numbers.sh << INPUT
   
|_|
  |
   
INPUT
    assert_success
    assert_output "4"
}

@test "Recognizes 5" {
    run bash ocr_numbers.sh << INPUT
 _ 
|_ 
 _|
   
INPUT
    assert_success
    assert_output "5"
}

@test "Recognizes 6" {
    run bash ocr_numbers.sh << INPUT
 _ 
|_ 
|_|
   
INPUT
    assert_success
    assert_output "6"
}

@test "Recognizes 7" {
    run bash ocr_numbers.sh << INPUT
 _ 
  |
  |
   
INPUT
    assert_success
    assert_output "7"
}

@test "Recognizes 8" {
    run bash ocr_numbers.sh << INPUT
 _ 
|_|
|_|
   
INPUT
    assert_success
    assert_output "8"
}

@test "Recognizes 9" {
    run bash ocr_numbers.sh << INPUT
 _ 
|_|
 _|
   
INPUT
    assert_success
    assert_output "9"
}

@test "Recognizes string of decimal numbers" {
    run bash ocr_numbers.sh << INPUT
    _  _     _  _  _  _  _  _ 
  | _| _||_||_ |_   ||_||_|| |
  ||_  _|  | _||_|  ||_| _||_|
                              
INPUT
    assert_success
    assert_output "1234567890"
}

@test "Numbers separated by empty lines are recognized. Lines are joined by commas." {
    run bash ocr_numbers.sh << INPUT
    _  _ 
  | _| _|
  ||_  _|
         
    _  _ 
|_||_ |_ 
  | _||_|
         
 _  _  _ 
  ||_||_|
  ||_| _|
         
INPUT
    assert_success
    assert_output "123,456,789"
}
