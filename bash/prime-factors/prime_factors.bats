#!/usr/bin/env bats
load bats-extra

# local version: 1.1.0.0

@test "no factors" {
    #[[ $BATS_RUN_SKIPPED == "true" ]] || skip
    expected=""
    run bash prime_factors.sh 1
    assert_success
    assert_output "$expected"
}

@test "prime number" {
    expected="2"
    run bash prime_factors.sh 2
    assert_success
    assert_output "$expected"
}

@test "another prime number" {
    expected="3"
    run bash prime_factors.sh 3
    assert_success
    assert_output "$expected"
}

@test "square of a prime" {
    expected="3 3"
    run bash prime_factors.sh 9
    assert_success
    assert_output "$expected"
}

@test "product of first prime" {
    expected="2 2"
    run bash prime_factors.sh 4
    assert_success
    assert_output "$expected"
}

@test "cube of a prime" {
    expected="2 2 2"
    run bash prime_factors.sh 8
    assert_success
    assert_output "$expected"
}

@test "product of second prime" {
    expected="3 3 3"
    run bash prime_factors.sh 27
    assert_success
    assert_output "$expected"
}

@test "product of third prime" {
    expected="5 5 5 5"
    run bash prime_factors.sh 625
    assert_success
    assert_output "$expected"
}

@test "product of first and second primes" {
    expected="2 3"
    run bash prime_factors.sh 6
    assert_success
    assert_output "$expected"
}

@test "product of primes and non-primes" {
    expected="2 2 3"
    run bash prime_factors.sh 12
    assert_success
    assert_output "$expected"
}

@test "product of primes" {
    expected="5 17 23 461"
    run bash prime_factors.sh 901255
    assert_success
    assert_output "$expected"
}

@test "factors include a large prime" {
    expected="11 9539 894119"
    run bash prime_factors.sh 93819012551
    assert_success
    assert_output "$expected"
}
