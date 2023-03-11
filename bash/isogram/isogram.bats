#!/usr/bin/env bats
load bats-extra

# local version: 1.7.0.0

# Check if the given string is an isogram

@test 'empty string' {
  #[[ $BATS_RUN_SKIPPED == "true" ]] || skip
  run bash isogram.sh ''
  assert_success
  assert_output "true"
}

@test 'isogram with only lower case characters' {
  run bash isogram.sh 'isogram'
  assert_success
  assert_output "true"
}

@test 'word with one duplicated character' {
  run bash isogram.sh 'eleven'
  assert_success
  assert_output "false"
}

@test 'word with one duplicated character from the end of the alphabet' {
  run bash isogram.sh 'zzyzx'
  assert_success
  assert_output "false"
}

@test 'longest reported english isogram' {
  run bash isogram.sh 'subdermatoglyphic'
  assert_success
  assert_output "true"
}

@test 'word with duplicated character in mixed case' {
  run bash isogram.sh 'Alphabet'
  assert_success
  assert_output "false"
}

@test 'hypothetical isogrammic word with hyphen' {
  run bash isogram.sh 'thumbscrew-japingly'
  assert_success
  assert_output "true"
}

@test 'isogram with duplicated hyphen' {
  run bash isogram.sh 'six-year-old'
  assert_success
  assert_output "true"
}

@test 'hypothetical word with duplicated character following hyphen' {
  run bash isogram.sh 'thumbscrew-jappingly'
  assert_success
  assert_output "false"
}

@test 'made-up name that is an isogram' {
  run bash isogram.sh 'Emily Jung Schwartzkopf'
  assert_success
  assert_output "true"
}

@test 'duplicated character in the middle' {
  run bash isogram.sh 'accentor'
  assert_success
  assert_output "false"
}

@test 'word with duplicated character in mixed case, lowercase first' {
  run bash isogram.sh 'alphAbet'
  assert_success
  assert_output "false"
}

@test 'same first and last characters' {
  run bash isogram.sh 'angola'
  assert_success
  assert_output "false"
}

@test 'word with duplicated character and with two hyphens' {
  run bash isogram.sh 'up-to-date'
  assert_success
  assert_output "false"
}
